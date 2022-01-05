package wiki.scene.web3jdemo.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class StorageContract extends Contract {
    public static final String BINARY = "0x608060405234801561001057600080fd5b5061012f806100206000396000f3fe6080604052348015600f57600080fd5b506004361060325760003560e01c80632e64cec11460375780636057361d146051575b600080fd5b603d6069565b6040516048919060c2565b60405180910390f35b6067600480360381019060639190608f565b6072565b005b60008054905090565b8060008190555050565b60008135905060898160e5565b92915050565b60006020828403121560a057600080fd5b600060ac84828501607c565b91505092915050565b60bc8160db565b82525050565b600060208201905060d5600083018460b5565b92915050565b6000819050919050565b60ec8160db565b811460f657600080fd5b5056fea2646970667358221220b9c82654132f6c17638fa37892e12bbc45d5cf5ae5040ad3f431482fe15de8f964736f6c63430008000033";

    public static final String FUNC_STORE = "store";

    public static final String FUNC_RETRIEVE = "retrieve";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected StorageContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected StorageContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected StorageContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected StorageContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> store(BigInteger num) {
        final Function function = new Function(
                FUNC_STORE, 
                Arrays.<Type>asList(new Uint256(num)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> retrieve() {
        final Function function = new Function(FUNC_RETRIEVE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static StorageContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new StorageContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static StorageContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new StorageContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static StorageContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new StorageContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static StorageContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new StorageContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<StorageContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(StorageContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<StorageContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(StorageContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<StorageContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(StorageContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<StorageContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(StorageContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
