// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: netscenegettrainprogress.proto

package com.cxy.oi.autogen;

public interface NetSceneGetTrainProgressRespOrBuilder extends
    // @@protoc_insertion_point(interface_extends:netscenegettrainprogress.NetSceneGetTrainProgressResp)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional bool is_running = 1;</code>
   * @return Whether the isRunning field is set.
   */
  boolean hasIsRunning();
  /**
   * <code>optional bool is_running = 1;</code>
   * @return The isRunning.
   */
  boolean getIsRunning();

  /**
   * <code>optional uint32 curr_epoch = 2;</code>
   * @return Whether the currEpoch field is set.
   */
  boolean hasCurrEpoch();
  /**
   * <code>optional uint32 curr_epoch = 2;</code>
   * @return The currEpoch.
   */
  int getCurrEpoch();

  /**
   * <code>optional uint32 total_epoch = 3;</code>
   * @return Whether the totalEpoch field is set.
   */
  boolean hasTotalEpoch();
  /**
   * <code>optional uint32 total_epoch = 3;</code>
   * @return The totalEpoch.
   */
  int getTotalEpoch();
}
