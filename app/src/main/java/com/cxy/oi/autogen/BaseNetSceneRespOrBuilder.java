// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: basenetsceneresp.proto

package com.cxy.oi.autogen;

public interface BaseNetSceneRespOrBuilder extends
    // @@protoc_insertion_point(interface_extends:basenetsceneresp.BaseNetSceneResp)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional int32 errcode = 1;</code>
   * @return Whether the errcode field is set.
   */
  boolean hasErrcode();
  /**
   * <code>optional int32 errcode = 1;</code>
   * @return The errcode.
   */
  int getErrcode();

  /**
   * <code>optional string errmsg = 2;</code>
   * @return Whether the errmsg field is set.
   */
  boolean hasErrmsg();
  /**
   * <code>optional string errmsg = 2;</code>
   * @return The errmsg.
   */
  java.lang.String getErrmsg();
  /**
   * <code>optional string errmsg = 2;</code>
   * @return The bytes for errmsg.
   */
  com.google.protobuf.ByteString
      getErrmsgBytes();

  /**
   * <code>optional bytes net_scene_resp_buff = 3;</code>
   * @return Whether the netSceneRespBuff field is set.
   */
  boolean hasNetSceneRespBuff();
  /**
   * <code>optional bytes net_scene_resp_buff = 3;</code>
   * @return The netSceneRespBuff.
   */
  com.google.protobuf.ByteString getNetSceneRespBuff();
}
