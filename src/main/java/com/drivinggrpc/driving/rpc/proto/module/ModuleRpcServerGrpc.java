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

  private static volatile io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.ExamRequest,
      com.drivinggrpc.driving.rpc.proto.module.ExamResponse> getGetExamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getExam",
      requestType = com.drivinggrpc.driving.rpc.proto.module.ExamRequest.class,
      responseType = com.drivinggrpc.driving.rpc.proto.module.ExamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.ExamRequest,
      com.drivinggrpc.driving.rpc.proto.module.ExamResponse> getGetExamMethod() {
    io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.ExamRequest, com.drivinggrpc.driving.rpc.proto.module.ExamResponse> getGetExamMethod;
    if ((getGetExamMethod = ModuleRpcServerGrpc.getGetExamMethod) == null) {
      synchronized (ModuleRpcServerGrpc.class) {
        if ((getGetExamMethod = ModuleRpcServerGrpc.getGetExamMethod) == null) {
          ModuleRpcServerGrpc.getGetExamMethod = getGetExamMethod =
              io.grpc.MethodDescriptor.<com.drivinggrpc.driving.rpc.proto.module.ExamRequest, com.drivinggrpc.driving.rpc.proto.module.ExamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getExam"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drivinggrpc.driving.rpc.proto.module.ExamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drivinggrpc.driving.rpc.proto.module.ExamResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ModuleRpcServerMethodDescriptorSupplier("getExam"))
              .build();
        }
      }
    }
    return getGetExamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.ExamRequest,
      com.drivinggrpc.driving.rpc.proto.module.ExamResponse> getGetExerciseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getExercise",
      requestType = com.drivinggrpc.driving.rpc.proto.module.ExamRequest.class,
      responseType = com.drivinggrpc.driving.rpc.proto.module.ExamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.ExamRequest,
      com.drivinggrpc.driving.rpc.proto.module.ExamResponse> getGetExerciseMethod() {
    io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.ExamRequest, com.drivinggrpc.driving.rpc.proto.module.ExamResponse> getGetExerciseMethod;
    if ((getGetExerciseMethod = ModuleRpcServerGrpc.getGetExerciseMethod) == null) {
      synchronized (ModuleRpcServerGrpc.class) {
        if ((getGetExerciseMethod = ModuleRpcServerGrpc.getGetExerciseMethod) == null) {
          ModuleRpcServerGrpc.getGetExerciseMethod = getGetExerciseMethod =
              io.grpc.MethodDescriptor.<com.drivinggrpc.driving.rpc.proto.module.ExamRequest, com.drivinggrpc.driving.rpc.proto.module.ExamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getExercise"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drivinggrpc.driving.rpc.proto.module.ExamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drivinggrpc.driving.rpc.proto.module.ExamResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ModuleRpcServerMethodDescriptorSupplier("getExercise"))
              .build();
        }
      }
    }
    return getGetExerciseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.ApplyExamRequest,
      com.drivinggrpc.driving.rpc.proto.module.ApplyExamResponse> getApplyExamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "applyExam",
      requestType = com.drivinggrpc.driving.rpc.proto.module.ApplyExamRequest.class,
      responseType = com.drivinggrpc.driving.rpc.proto.module.ApplyExamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.ApplyExamRequest,
      com.drivinggrpc.driving.rpc.proto.module.ApplyExamResponse> getApplyExamMethod() {
    io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.ApplyExamRequest, com.drivinggrpc.driving.rpc.proto.module.ApplyExamResponse> getApplyExamMethod;
    if ((getApplyExamMethod = ModuleRpcServerGrpc.getApplyExamMethod) == null) {
      synchronized (ModuleRpcServerGrpc.class) {
        if ((getApplyExamMethod = ModuleRpcServerGrpc.getApplyExamMethod) == null) {
          ModuleRpcServerGrpc.getApplyExamMethod = getApplyExamMethod =
              io.grpc.MethodDescriptor.<com.drivinggrpc.driving.rpc.proto.module.ApplyExamRequest, com.drivinggrpc.driving.rpc.proto.module.ApplyExamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "applyExam"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drivinggrpc.driving.rpc.proto.module.ApplyExamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drivinggrpc.driving.rpc.proto.module.ApplyExamResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ModuleRpcServerMethodDescriptorSupplier("applyExam"))
              .build();
        }
      }
    }
    return getApplyExamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.ApplyExamRequest,
      com.drivinggrpc.driving.rpc.proto.module.ApplyExamResponse> getApplyExerciseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "applyExercise",
      requestType = com.drivinggrpc.driving.rpc.proto.module.ApplyExamRequest.class,
      responseType = com.drivinggrpc.driving.rpc.proto.module.ApplyExamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.ApplyExamRequest,
      com.drivinggrpc.driving.rpc.proto.module.ApplyExamResponse> getApplyExerciseMethod() {
    io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.ApplyExamRequest, com.drivinggrpc.driving.rpc.proto.module.ApplyExamResponse> getApplyExerciseMethod;
    if ((getApplyExerciseMethod = ModuleRpcServerGrpc.getApplyExerciseMethod) == null) {
      synchronized (ModuleRpcServerGrpc.class) {
        if ((getApplyExerciseMethod = ModuleRpcServerGrpc.getApplyExerciseMethod) == null) {
          ModuleRpcServerGrpc.getApplyExerciseMethod = getApplyExerciseMethod =
              io.grpc.MethodDescriptor.<com.drivinggrpc.driving.rpc.proto.module.ApplyExamRequest, com.drivinggrpc.driving.rpc.proto.module.ApplyExamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "applyExercise"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drivinggrpc.driving.rpc.proto.module.ApplyExamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drivinggrpc.driving.rpc.proto.module.ApplyExamResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ModuleRpcServerMethodDescriptorSupplier("applyExercise"))
              .build();
        }
      }
    }
    return getApplyExerciseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.NewsRequest,
      com.drivinggrpc.driving.rpc.proto.module.NewsResponse> getGetNewsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getNews",
      requestType = com.drivinggrpc.driving.rpc.proto.module.NewsRequest.class,
      responseType = com.drivinggrpc.driving.rpc.proto.module.NewsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.NewsRequest,
      com.drivinggrpc.driving.rpc.proto.module.NewsResponse> getGetNewsMethod() {
    io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.NewsRequest, com.drivinggrpc.driving.rpc.proto.module.NewsResponse> getGetNewsMethod;
    if ((getGetNewsMethod = ModuleRpcServerGrpc.getGetNewsMethod) == null) {
      synchronized (ModuleRpcServerGrpc.class) {
        if ((getGetNewsMethod = ModuleRpcServerGrpc.getGetNewsMethod) == null) {
          ModuleRpcServerGrpc.getGetNewsMethod = getGetNewsMethod =
              io.grpc.MethodDescriptor.<com.drivinggrpc.driving.rpc.proto.module.NewsRequest, com.drivinggrpc.driving.rpc.proto.module.NewsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getNews"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drivinggrpc.driving.rpc.proto.module.NewsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drivinggrpc.driving.rpc.proto.module.NewsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ModuleRpcServerMethodDescriptorSupplier("getNews"))
              .build();
        }
      }
    }
    return getGetNewsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.ReadNewsRequest,
      com.drivinggrpc.driving.rpc.proto.module.ReadNewsResponse> getReadNewsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "readNews",
      requestType = com.drivinggrpc.driving.rpc.proto.module.ReadNewsRequest.class,
      responseType = com.drivinggrpc.driving.rpc.proto.module.ReadNewsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.ReadNewsRequest,
      com.drivinggrpc.driving.rpc.proto.module.ReadNewsResponse> getReadNewsMethod() {
    io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.ReadNewsRequest, com.drivinggrpc.driving.rpc.proto.module.ReadNewsResponse> getReadNewsMethod;
    if ((getReadNewsMethod = ModuleRpcServerGrpc.getReadNewsMethod) == null) {
      synchronized (ModuleRpcServerGrpc.class) {
        if ((getReadNewsMethod = ModuleRpcServerGrpc.getReadNewsMethod) == null) {
          ModuleRpcServerGrpc.getReadNewsMethod = getReadNewsMethod =
              io.grpc.MethodDescriptor.<com.drivinggrpc.driving.rpc.proto.module.ReadNewsRequest, com.drivinggrpc.driving.rpc.proto.module.ReadNewsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "readNews"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drivinggrpc.driving.rpc.proto.module.ReadNewsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drivinggrpc.driving.rpc.proto.module.ReadNewsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ModuleRpcServerMethodDescriptorSupplier("readNews"))
              .build();
        }
      }
    }
    return getReadNewsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.BillRequest,
      com.drivinggrpc.driving.rpc.proto.module.BillResponse> getGetBillMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getBill",
      requestType = com.drivinggrpc.driving.rpc.proto.module.BillRequest.class,
      responseType = com.drivinggrpc.driving.rpc.proto.module.BillResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.BillRequest,
      com.drivinggrpc.driving.rpc.proto.module.BillResponse> getGetBillMethod() {
    io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.BillRequest, com.drivinggrpc.driving.rpc.proto.module.BillResponse> getGetBillMethod;
    if ((getGetBillMethod = ModuleRpcServerGrpc.getGetBillMethod) == null) {
      synchronized (ModuleRpcServerGrpc.class) {
        if ((getGetBillMethod = ModuleRpcServerGrpc.getGetBillMethod) == null) {
          ModuleRpcServerGrpc.getGetBillMethod = getGetBillMethod =
              io.grpc.MethodDescriptor.<com.drivinggrpc.driving.rpc.proto.module.BillRequest, com.drivinggrpc.driving.rpc.proto.module.BillResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getBill"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drivinggrpc.driving.rpc.proto.module.BillRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drivinggrpc.driving.rpc.proto.module.BillResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ModuleRpcServerMethodDescriptorSupplier("getBill"))
              .build();
        }
      }
    }
    return getGetBillMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.PayRequest,
      com.drivinggrpc.driving.rpc.proto.module.PayResponse> getBillPayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "billPay",
      requestType = com.drivinggrpc.driving.rpc.proto.module.PayRequest.class,
      responseType = com.drivinggrpc.driving.rpc.proto.module.PayResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.PayRequest,
      com.drivinggrpc.driving.rpc.proto.module.PayResponse> getBillPayMethod() {
    io.grpc.MethodDescriptor<com.drivinggrpc.driving.rpc.proto.module.PayRequest, com.drivinggrpc.driving.rpc.proto.module.PayResponse> getBillPayMethod;
    if ((getBillPayMethod = ModuleRpcServerGrpc.getBillPayMethod) == null) {
      synchronized (ModuleRpcServerGrpc.class) {
        if ((getBillPayMethod = ModuleRpcServerGrpc.getBillPayMethod) == null) {
          ModuleRpcServerGrpc.getBillPayMethod = getBillPayMethod =
              io.grpc.MethodDescriptor.<com.drivinggrpc.driving.rpc.proto.module.PayRequest, com.drivinggrpc.driving.rpc.proto.module.PayResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "billPay"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drivinggrpc.driving.rpc.proto.module.PayRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.drivinggrpc.driving.rpc.proto.module.PayResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ModuleRpcServerMethodDescriptorSupplier("billPay"))
              .build();
        }
      }
    }
    return getBillPayMethod;
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

    /**
     */
    public void getExam(com.drivinggrpc.driving.rpc.proto.module.ExamRequest request,
        io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.ExamResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetExamMethod(), responseObserver);
    }

    /**
     */
    public void getExercise(com.drivinggrpc.driving.rpc.proto.module.ExamRequest request,
        io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.ExamResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetExerciseMethod(), responseObserver);
    }

    /**
     */
    public void applyExam(com.drivinggrpc.driving.rpc.proto.module.ApplyExamRequest request,
        io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.ApplyExamResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getApplyExamMethod(), responseObserver);
    }

    /**
     */
    public void applyExercise(com.drivinggrpc.driving.rpc.proto.module.ApplyExamRequest request,
        io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.ApplyExamResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getApplyExerciseMethod(), responseObserver);
    }

    /**
     */
    public void getNews(com.drivinggrpc.driving.rpc.proto.module.NewsRequest request,
        io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.NewsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetNewsMethod(), responseObserver);
    }

    /**
     */
    public void readNews(com.drivinggrpc.driving.rpc.proto.module.ReadNewsRequest request,
        io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.ReadNewsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getReadNewsMethod(), responseObserver);
    }

    /**
     */
    public void getBill(com.drivinggrpc.driving.rpc.proto.module.BillRequest request,
        io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.BillResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBillMethod(), responseObserver);
    }

    /**
     */
    public void billPay(com.drivinggrpc.driving.rpc.proto.module.PayRequest request,
        io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.PayResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getBillPayMethod(), responseObserver);
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
          .addMethod(
            getGetExamMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.drivinggrpc.driving.rpc.proto.module.ExamRequest,
                com.drivinggrpc.driving.rpc.proto.module.ExamResponse>(
                  this, METHODID_GET_EXAM)))
          .addMethod(
            getGetExerciseMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.drivinggrpc.driving.rpc.proto.module.ExamRequest,
                com.drivinggrpc.driving.rpc.proto.module.ExamResponse>(
                  this, METHODID_GET_EXERCISE)))
          .addMethod(
            getApplyExamMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.drivinggrpc.driving.rpc.proto.module.ApplyExamRequest,
                com.drivinggrpc.driving.rpc.proto.module.ApplyExamResponse>(
                  this, METHODID_APPLY_EXAM)))
          .addMethod(
            getApplyExerciseMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.drivinggrpc.driving.rpc.proto.module.ApplyExamRequest,
                com.drivinggrpc.driving.rpc.proto.module.ApplyExamResponse>(
                  this, METHODID_APPLY_EXERCISE)))
          .addMethod(
            getGetNewsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.drivinggrpc.driving.rpc.proto.module.NewsRequest,
                com.drivinggrpc.driving.rpc.proto.module.NewsResponse>(
                  this, METHODID_GET_NEWS)))
          .addMethod(
            getReadNewsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.drivinggrpc.driving.rpc.proto.module.ReadNewsRequest,
                com.drivinggrpc.driving.rpc.proto.module.ReadNewsResponse>(
                  this, METHODID_READ_NEWS)))
          .addMethod(
            getGetBillMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.drivinggrpc.driving.rpc.proto.module.BillRequest,
                com.drivinggrpc.driving.rpc.proto.module.BillResponse>(
                  this, METHODID_GET_BILL)))
          .addMethod(
            getBillPayMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.drivinggrpc.driving.rpc.proto.module.PayRequest,
                com.drivinggrpc.driving.rpc.proto.module.PayResponse>(
                  this, METHODID_BILL_PAY)))
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

    /**
     */
    public void getExam(com.drivinggrpc.driving.rpc.proto.module.ExamRequest request,
        io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.ExamResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetExamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getExercise(com.drivinggrpc.driving.rpc.proto.module.ExamRequest request,
        io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.ExamResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetExerciseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void applyExam(com.drivinggrpc.driving.rpc.proto.module.ApplyExamRequest request,
        io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.ApplyExamResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getApplyExamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void applyExercise(com.drivinggrpc.driving.rpc.proto.module.ApplyExamRequest request,
        io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.ApplyExamResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getApplyExerciseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getNews(com.drivinggrpc.driving.rpc.proto.module.NewsRequest request,
        io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.NewsResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetNewsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readNews(com.drivinggrpc.driving.rpc.proto.module.ReadNewsRequest request,
        io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.ReadNewsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadNewsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBill(com.drivinggrpc.driving.rpc.proto.module.BillRequest request,
        io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.BillResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetBillMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void billPay(com.drivinggrpc.driving.rpc.proto.module.PayRequest request,
        io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.PayResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBillPayMethod(), getCallOptions()), request, responseObserver);
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

    /**
     */
    public java.util.Iterator<com.drivinggrpc.driving.rpc.proto.module.ExamResponse> getExam(
        com.drivinggrpc.driving.rpc.proto.module.ExamRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetExamMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.drivinggrpc.driving.rpc.proto.module.ExamResponse> getExercise(
        com.drivinggrpc.driving.rpc.proto.module.ExamRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetExerciseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.drivinggrpc.driving.rpc.proto.module.ApplyExamResponse applyExam(com.drivinggrpc.driving.rpc.proto.module.ApplyExamRequest request) {
      return blockingUnaryCall(
          getChannel(), getApplyExamMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.drivinggrpc.driving.rpc.proto.module.ApplyExamResponse applyExercise(com.drivinggrpc.driving.rpc.proto.module.ApplyExamRequest request) {
      return blockingUnaryCall(
          getChannel(), getApplyExerciseMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.drivinggrpc.driving.rpc.proto.module.NewsResponse> getNews(
        com.drivinggrpc.driving.rpc.proto.module.NewsRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetNewsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.drivinggrpc.driving.rpc.proto.module.ReadNewsResponse readNews(com.drivinggrpc.driving.rpc.proto.module.ReadNewsRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadNewsMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.drivinggrpc.driving.rpc.proto.module.BillResponse> getBill(
        com.drivinggrpc.driving.rpc.proto.module.BillRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetBillMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.drivinggrpc.driving.rpc.proto.module.PayResponse billPay(com.drivinggrpc.driving.rpc.proto.module.PayRequest request) {
      return blockingUnaryCall(
          getChannel(), getBillPayMethod(), getCallOptions(), request);
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

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.drivinggrpc.driving.rpc.proto.module.ApplyExamResponse> applyExam(
        com.drivinggrpc.driving.rpc.proto.module.ApplyExamRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getApplyExamMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.drivinggrpc.driving.rpc.proto.module.ApplyExamResponse> applyExercise(
        com.drivinggrpc.driving.rpc.proto.module.ApplyExamRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getApplyExerciseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.drivinggrpc.driving.rpc.proto.module.ReadNewsResponse> readNews(
        com.drivinggrpc.driving.rpc.proto.module.ReadNewsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadNewsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.drivinggrpc.driving.rpc.proto.module.PayResponse> billPay(
        com.drivinggrpc.driving.rpc.proto.module.PayRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBillPayMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_APPLY = 0;
  private static final int METHODID_GET_APPLY_STATE = 1;
  private static final int METHODID_GET_STATISTICS_DATA = 2;
  private static final int METHODID_GET_EXAM = 3;
  private static final int METHODID_GET_EXERCISE = 4;
  private static final int METHODID_APPLY_EXAM = 5;
  private static final int METHODID_APPLY_EXERCISE = 6;
  private static final int METHODID_GET_NEWS = 7;
  private static final int METHODID_READ_NEWS = 8;
  private static final int METHODID_GET_BILL = 9;
  private static final int METHODID_BILL_PAY = 10;

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
        case METHODID_GET_EXAM:
          serviceImpl.getExam((com.drivinggrpc.driving.rpc.proto.module.ExamRequest) request,
              (io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.ExamResponse>) responseObserver);
          break;
        case METHODID_GET_EXERCISE:
          serviceImpl.getExercise((com.drivinggrpc.driving.rpc.proto.module.ExamRequest) request,
              (io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.ExamResponse>) responseObserver);
          break;
        case METHODID_APPLY_EXAM:
          serviceImpl.applyExam((com.drivinggrpc.driving.rpc.proto.module.ApplyExamRequest) request,
              (io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.ApplyExamResponse>) responseObserver);
          break;
        case METHODID_APPLY_EXERCISE:
          serviceImpl.applyExercise((com.drivinggrpc.driving.rpc.proto.module.ApplyExamRequest) request,
              (io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.ApplyExamResponse>) responseObserver);
          break;
        case METHODID_GET_NEWS:
          serviceImpl.getNews((com.drivinggrpc.driving.rpc.proto.module.NewsRequest) request,
              (io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.NewsResponse>) responseObserver);
          break;
        case METHODID_READ_NEWS:
          serviceImpl.readNews((com.drivinggrpc.driving.rpc.proto.module.ReadNewsRequest) request,
              (io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.ReadNewsResponse>) responseObserver);
          break;
        case METHODID_GET_BILL:
          serviceImpl.getBill((com.drivinggrpc.driving.rpc.proto.module.BillRequest) request,
              (io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.BillResponse>) responseObserver);
          break;
        case METHODID_BILL_PAY:
          serviceImpl.billPay((com.drivinggrpc.driving.rpc.proto.module.PayRequest) request,
              (io.grpc.stub.StreamObserver<com.drivinggrpc.driving.rpc.proto.module.PayResponse>) responseObserver);
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
              .addMethod(getGetExamMethod())
              .addMethod(getGetExerciseMethod())
              .addMethod(getApplyExamMethod())
              .addMethod(getApplyExerciseMethod())
              .addMethod(getGetNewsMethod())
              .addMethod(getReadNewsMethod())
              .addMethod(getGetBillMethod())
              .addMethod(getBillPayMethod())
              .build();
        }
      }
    }
    return result;
  }
}
