package ru.gnkoshelev.j4net.sample.hash.grpc.server;

import io.grpc.stub.StreamObserver;
import ru.gnkoshelev.j4net.sample.hash.lib.Hasher;

/**
 * Created by kgn on 13.03.2018.
 */
public class HashServiceImpl extends HashServiceGrpc.HashServiceImplBase {
    @Override
    public void compute(HashRequest request, StreamObserver<HashResponse> responseObserver) {
        HashResponse response = HashResponse.newBuilder()
                .setHash(Hasher.compute(request.getAlgorithm(), request.getBytes().toByteArray()))
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
