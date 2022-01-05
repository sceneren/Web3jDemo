package wiki.scene.web3jdemo.contract

import org.web3j.tx.gas.StaticGasProvider
import java.math.BigInteger

class CustomGasProvider : StaticGasProvider(
    BigInteger.valueOf(4100000000L), BigInteger.valueOf(3000000)
)