// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: basenetsceneresp.proto

package com.cxy.oi.autogen;

public final class BaseNetSceneRespProto {
  private BaseNetSceneRespProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_basenetsceneresp_BaseNetSceneResp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_basenetsceneresp_BaseNetSceneResp_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026basenetsceneresp.proto\022\020basenetscenere" +
      "sp\"P\n\020BaseNetSceneResp\022\017\n\007errcode\030\001 \001(\005\022" +
      "\016\n\006errmsg\030\002 \001(\t\022\033\n\023net_scene_resp_buff\030\003" +
      " \001(\014B-\n\022com.cxy.oi.autogenB\025BaseNetScene" +
      "RespProtoP\001"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_basenetsceneresp_BaseNetSceneResp_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_basenetsceneresp_BaseNetSceneResp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_basenetsceneresp_BaseNetSceneResp_descriptor,
        new java.lang.String[] { "Errcode", "Errmsg", "NetSceneRespBuff", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
