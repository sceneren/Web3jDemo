package wiki.scene.web3jdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.web3j.crypto.Credentials
import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService
import org.web3j.tx.gas.ContractGasProvider
import wiki.scene.web3jdemo.contract.CustomGasProvider
import wiki.scene.web3jdemo.contract.StorageContract
import wiki.scene.web3jdemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    private val ownerAddress by lazy {
        "0xE89E998F005F7Da072fc09f43b179Ad83bC26146"
    }
    private val contractAddress by lazy {
        "0xD2E7c76D7a8a5488fb055653A7eA3De37af15cf3"
    }
    private lateinit var web3: Web3j

    private lateinit var credentials: Credentials
    private lateinit var contractGasProvider: ContractGasProvider
    private lateinit var storageContract: StorageContract

    private var startTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        initStorageContract()

        mBinding.btnStore
            .setOnClickListener {
                val number = mBinding.etNumber.text.toString().toBigIntegerOrNull()
                    ?: return@setOnClickListener
                GlobalScope.launch {
                    flow {
                        val result = storageContract.store(number)
                            .send()
                        emit(result)
                    }.flowOn(Dispatchers.IO)
                        .onStart {
                            startTime = System.currentTimeMillis()
                        }.catch {
                            it.printStackTrace()
                            mBinding.tvLog.text = it.message
                        }.onEach {
                            mBinding.tvLog.text =
                                "Use Time:${(System.currentTimeMillis() - startTime)}\nresult:$it"
                        }.catch {
                            it.printStackTrace()
                            mBinding.tvLog.text = it.message
                        }.flowOn(Dispatchers.Main)
                        .collect()
                }
            }

        mBinding.btnRetrieve
            .setOnClickListener {
                GlobalScope.launch {
                    flow {
                        val result = storageContract.retrieve()
                            .send()
                        emit(result)
                    }.flowOn(Dispatchers.IO)
                        .onStart {
                            startTime = System.currentTimeMillis()
                        }.catch {
                            it.printStackTrace()
                            mBinding.tvLog.text = it.message
                        }.onEach {
                            mBinding.tvLog.text =
                                "Use Time:${(System.currentTimeMillis() - startTime)}\nresult:$it"
                        }.catch {
                            it.printStackTrace()
                            mBinding.tvLog.text = it.message
                        }.flowOn(Dispatchers.Main)
                        .collect()
                }
            }

    }

    private fun initStorageContract() {
        web3 = Web3j.build(HttpService("http://192.168.110.128:7545"))
        credentials =
            Credentials.create("5969cf7f35710b01e49c3b3472fa018868ea6765942846686c4341a9efc65fed")
        contractGasProvider = CustomGasProvider()
        storageContract =
            StorageContract.load(contractAddress, web3, credentials, contractGasProvider)
    }

    override fun onDestroy() {
        super.onDestroy()
        web3.shutdown()
    }
}