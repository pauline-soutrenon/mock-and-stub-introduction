#include "clients/ClientRepository.h"
#include "kata/BirthdayService.h"

BirthdayService::BirthdayService(ClientRepository& withRepository, Mailer& withMailer) {
    repository = &withRepository;
    mailer = &withMailer;
}
  
void BirthdayService::greeting(std::string name) const{

    std::string greeting;

    if (repository->birthdayIsTodayFor(name)) {
        greeting = "Happy birthday " + name + "!";
    } else {
        greeting = "Good morning " + name + ".";
    }
    mailer->send(greeting);
}
