// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: netsceneuploadavatar.proto

package com.cxy.oi.autogen;

public final class NetSceneUploadAvatarProto {
  private NetSceneUploadAvatarProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_netsceneuploadavatar_NetSceneUploadAvatarReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_netsceneuploadavatar_NetSceneUploadAvatarReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_netsceneuploadavatar_NetSceneUploadAvatarResp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_netsceneuploadavatar_NetSceneUploadAvatarResp_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\032netsceneuploadavatar.proto\022\024netsceneup" +
      "loadavatar\"C\n\027NetSceneUploadAvatarReq\022\016\n" +
      "\006usr_id\030\001 \001(\r\022\030\n\020avatar_img_bytes\030\002 \001(\014\"" +
      "\'\n\030NetSceneUploadAvatarResp\022\013\n\003nop\030\001 \001(\010" +
      "B1\n\022com.cxy.oi.autogenB\031NetSceneUploadAv" +
      "atarProtoP\001"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_netsceneuploadavatar_NetSceneUploadAvatarReq_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_netsceneuploadavatar_NetSceneUploadAvatarReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_netsceneuploadavatar_NetSceneUploadAvatarReq_descriptor,
        new java.lang.String[] { "UsrId", "AvatarImgBytes", });
    internal_static_netsceneuploadavatar_NetSceneUploadAvatarResp_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_netsceneuploadavatar_NetSceneUploadAvatarResp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_netsceneuploadavatar_NetSceneUploadAvatarResp_descriptor,
        new java.lang.String[] { "Nop", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}