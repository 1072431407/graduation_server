package com.drivinggrpc.driving.rpc.proto.module;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.27.0)",
    comments = "Source: module.proto")
public final class ModuleRpcServerGrpc {

  private ModuleRpcServerGrpc() {}

  public static final String SERVICE_NAME = "com.drivinggrpc.driving.rpc.proto.module.ModuleRpcServer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.ApplyRequest,
      com.drivinggrpc.driving.rpc.proto.module.ApplyResponse> getApplyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "apply",
      requestType = com.drivinggrpc.driving.rpc.proto.module.ApplyRequest.class,
      responseType = com.drivinggrpc.driving.rpc.proto.module.ApplyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.ApplyRequest,
      com.drivinggrpc.driving.rpc.proto.module.ApplyResponse> getApplyMethod() {
    io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.ApplyRequest, com.drivinggrpc.driving.rpc.proto.module.ApplyResponse> getApplyMethod;
    if ((getApplyMethod = ModuleRpcServerGrpc.getApplyMethod) == null) {
      synchronized (ModuleRpcServerGrpc.class) {
        if ((getApplyMethod = ModuleRpcServerGrpc.getApplyMethod) == null) {
          ModuleRpcServerGrpc.getApplyMethod = getApplyMethod =
              io.grpc.MethodDescriptor.<com.drivinggrpc.driving.rpc.proto.module.ApplyRequest, com.drivinggrpc.driving.rpc.proto.module.ApplyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "apply"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drivinggrpc.driving.rpc.proto.module.ApplyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drivinggrpc.driving.rpc.proto.module.ApplyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ModuleRpcServerMethodDescriptorSupplier("apply"))
              .build();
        }
      }
    }
    return getApplyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.ApplyStateRequest,
      com.drivinggrpc.driving.rpc.proto.module.ApplyStateResponse> getGetApplyStateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getApplyState",
      requestType = com.drivinggrpc.driving.rpc.proto.module.ApplyStateRequest.class,
      responseType = com.drivinggrpc.driving.rpc.proto.module.ApplyStateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.ApplyStateRequest,
      com.drivinggrpc.driving.rpc.proto.module.ApplyStateResponse> getGetApplyStateMethod() {
    io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.ApplyStateRequest, com.drivinggrpc.driving.rpc.proto.module.ApplyStateResponse> getGetApplyStateMethod;
    if ((getGetApplyStateMethod = ModuleRpcServerGrpc.getGetApplyStateMethod) == null) {
      synchronized (ModuleRpcServerGrpc.class) {
        if ((getGetApplyStateMethod = ModuleRpcServerGrpc.getGetApplyStateMethod) == null) {
          ModuleRpcServerGrpc.getGetApplyStateMethod = getGetApplyStateMethod =
              io.grpc.MethodDescriptor.<com.drivinggrpc.driving.rpc.proto.module.ApplyStateRequest, com.drivinggrpc.driving.rpc.proto.module.ApplyStateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getApplyState"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drivinggrpc.driving.rpc.proto.module.ApplyStateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drivinggrpc.driving.rpc.proto.module.ApplyStateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ModuleRpcServerMethodDescriptorSupplier("getApplyState"))
              .build();
        }
      }
    }
    return getGetApplyStateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.StatisticsDataRequest,
      com.drivinggrpc.driving.rpc.proto.module.StatisticsDataResponse> getGetStatisticsDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getStatisticsData",
      requestType = com.drivinggrpc.driving.rpc.proto.module.StatisticsDataRequest.class,
      responseType = com.drivinggrpc.driving.rpc.proto.module.StatisticsDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.StatisticsDataRequest,
      com.drivinggrpc.driving.rpc.proto.module.StatisticsDataResponse> getGetStatisticsDataMethod() {
    io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.StatisticsDataRequest, com.drivinggrpc.driving.rpc.proto.module.StatisticsDataResponse> getGetStatisticsDataMethod;
    if ((getGetStatisticsDataMethod = ModuleRpcServerGrpc.getGetStatisticsDataMethod) == null) {
      synchronized (ModuleRpcServerGrpc.class) {
        if ((getGetStatisticsDataMethod = ModuleRpcServerGrpc.getGetStatisticsDataMethod) == null) {
          ModuleRpcServerGrpc.getGetStatisticsDataMethod = getGetStatisticsDataMethod =
              io.grpc.MethodDescriptor.<com.drivinggrpc.driving.rpc.proto.module.StatisticsDataRequest, com.drivinggrpc.driving.rpc.proto.module.StatisticsDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getStatisticsData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drivinggrpc.driving.rpc.proto.module.StatisticsDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drivinggrpc.driving.rpc.proto.module.StatisticsDataResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ModuleRpcServerMethodDescriptorSupplier("getStatisticsData"))
              .build();
        }
      }
    }
    return getGetStatisticsDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ModuleRpcServerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModuleRpcServerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ModuleRpcServerStub>() {
        @java.lang.Override
        public ModuleRpcServerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ModuleRpcServerStub(channel, callOptions);
        }
      };
    return ModuleRpcServerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ModuleRpcServerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModuleRpcServerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ModuleRpcServerBlockingStub>() {
        @java.lang.Override
        public ModuleRpcServerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ModuleRpcServerBlockingStub(channel, callOptions);
        }
      };
    return ModuleRpcServerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ModuleRpcServerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModuleRpcServerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ModuleRpcServerFutureStub>() {
        @java.lang.Override
        public ModuleRpcServerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ModuleRpcServerFutureStub(channel, callOptions);
        }
      };
    return ModuleRpcServerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ModuleRpcServerImplBase implements io.grpc.BindableService {

    /**
     */
    public void apply(com.drivinggrpc.driving.rpc.proto.module.ApplyRequest request,
        io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.ApplyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getApplyMethod(), responseObserver);
    }

    /**
     */
    public void getApplyState(com.drivinggrpc.driving.rpc.proto.module.ApplyStateRequest request,
        io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.ApplyStateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetApplyStateMethod(), responseObserver);
    }

    /**
     */
    public void getStatisticsData(com.drivinggrpc.driving.rpc.proto.module.StatisticsDataRequest request,
        io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.StatisticsDataResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStatisticsDataMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getApplyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.drivinggrpc.driving.rpc.proto.module.ApplyRequest,
                com.drivinggrpc.driving.rpc.proto.module.ApplyResponse>(
                  this, METHODID_APPLY)))
          .addMethod(
            getGetApplyStateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.drivinggrpc.driving.rpc.proto.module.ApplyStateRequest,
                com.drivinggrpc.driving.rpc.proto.module.ApplyStateResponse>(
                  this, METHODID_GET_APPLY_STATE)))
          .addMethod(
            getGetStatisticsDataMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.drivinggrpc.driving.rpc.proto.module.StatisticsDataRequest,
                com.drivinggrpc.driving.rpc.proto.module.StatisticsDataResponse>(
                  this, METHODID_GET_STATISTICS_DATA)))
          .build();
    }
  }

  /**
   */
  public static final class ModuleRpcServerStub extends io.grpc.stub.AbstractAsyncStub<ModuleRpcServerStub> {
    private ModuleRpcServerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModuleRpcServerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModuleRpcServerStub(channel, callOptions);
    }

    /**
     */
    public void apply(com.drivinggrpc.driving.rpc.proto.module.ApplyRequest request,
        io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.ApplyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getApplyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getApplyState(com.drivinggrpc.driving.rpc.proto.module.ApplyStateRequest request,
        io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.ApplyStateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetApplyStateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getStatisticsData(com.drivinggrpc.driving.rpc.proto.module.StatisticsDataRequest request,
        io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.StatisticsDataResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetStatisticsDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ModuleRpcServerBlockingStub extends io.grpc.stub.AbstractBlockingStub<ModuleRpcServerBlockingStub> {
    private ModuleRpcServerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModuleRpcServerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModuleRpcServerBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.drivinggrpc.driving.rpc.proto.module.ApplyResponse apply(com.drivinggrpc.driving.rpc.proto.module.ApplyRequest request) {
      return blockingUnaryCall(
          getChannel(), getApplyMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.drivinggrpc.driving.rpc.proto.module.ApplyStateResponse getApplyState(com.drivinggrpc.driving.rpc.proto.module.ApplyStateRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetApplyStateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.drivinggrpc.driving.rpc.proto.module.StatisticsDataResponse getStatisticsData(com.drivinggrpc.driving.rpc.proto.module.StatisticsDataRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetStatisticsDataMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ModuleRpcServerFutureStub extends io.grpc.stub.AbstractFutureStub<ModuleRpcServerFutureStub> {
    private ModuleRpcServerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModuleRpcServerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModuleRpcServerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.drivinggrpc.driving.rpc.proto.module.ApplyResponse> apply(
        com.drivinggrpc.driving.rpc.proto.module.ApplyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getApplyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.drivinggrpc.driving.rpc.proto.module.ApplyStateResponse> getApplyState(
        com.drivinggrpc.driving.rpc.proto.module.ApplyStateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetApplyStateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.drivinggrpc.driving.rpc.proto.module.StatisticsDataResponse> getStatisticsData(
        com.drivinggrpc.driving.rpc.proto.module.StatisticsDataRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetStatisticsDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_APPLY = 0;
  private static final int METHODID_GET_APPLY_STATE = 1;
  private static final int METHODID_GET_STATISTICS_DATA = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ModuleRpcServerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ModuleRpcServerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_APPLY:
          serviceImpl.apply((com.drivinggrpc.driving.rpc.proto.module.ApplyRequest) request,
              (io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.ApplyResponse>) responseObserver);
          break;
        case METHODID_GET_APPLY_STATE:
          serviceImpl.getApplyState((com.drivinggrpc.driving.rpc.proto.module.ApplyStateRequest) request,
              (io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.ApplyStateResponse>) responseObserver);
          break;
        case METHODID_GET_STATISTICS_DATA:
          serviceImpl.getStatisticsData((com.drivinggrpc.driving.rpc.proto.module.StatisticsDataRequest) request,
              (io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.StatisticsDataResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ModuleRpcServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ModuleRpcServerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.drivinggrpc.driving.rpc.proto.module.ModuleProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ModuleRpcServer");
    }
  }

  private static final class ModuleRpcServerFileDescriptorSupplier
      extends ModuleRpcServerBaseDescriptorSupplier {
    ModuleRpcServerFileDescriptorSupplier() {}
  }

  private static final class ModuleRpcServerMethodDescriptorSupplier
      extends ModuleRpcServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ModuleRpcServerMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ModuleRpcServerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ModuleRpcServerFileDescriptorSupplier())
              .addMethod(getApplyMethod())
              .addMethod(getGetApplyStateMethod())
              .addMethod(getGetStatisticsDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
