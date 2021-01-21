#ifndef OI_SHORTLINK_H
#define OI_SHORTLINK_H

#include "task.h"
#include "thread.h"
#include "socket/unix_socket.h"
#include "autobuffer.h"


class ShortLink {
  public:
    explicit ShortLink(Task &_task, const std::string& _svr_inet_addr = "127.0.0.1",
            u_short _port = 5002, bool _use_proxy = false);

    void DoConnect();

    AutoBuffer &GetSendBody();

    AutoBuffer &GetRecvBuff();

    int DoTask();

    int GetNetId() const;

    u_short GetPort() const;

    pthread_t GetTid() const;

    int GetErrCode() const;

    std::string &GetCgi();

    std::string &GetHost();

  private:
    void __ReadWrite();
    int __Run();

  private:
    Task            task_;
    Thread          thread_;
    const bool      use_proxy_;
    int             err_code_;
    SOCKET          socket_;
    AutoBuffer      send_body_;
    AutoBuffer      recv_buff_;
    u_short         port_;
    std::string     svr_inet_addr_;

};


#endif //OI_SHORTLINK_H
