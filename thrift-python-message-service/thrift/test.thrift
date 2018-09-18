namespace java com.thrift.service
namespace py messageservice


service MesageService{
    bool sendMobileMessage(1:string mobile,2:string message)

    bool semdMailMessage(1:string mail,2:string message)
}