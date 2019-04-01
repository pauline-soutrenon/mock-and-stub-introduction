#include "clients/ClientRepository.h"
#include "kata/BirthdayService.h"

BirthdayService::BirthdayService(ClientRepository& withRepository) {
    repository = &withRepository;
}
  
std::string BirthdayService::greeting(std::string name) const{

    std::string greeting;

    if (repository->birthdayIsTodayFor(name)) {
        greeting = "Happy birthday " + name + "!";
    } else {
        greeting = "Good morning " + name + ".";
    }
    return greeting;
}
