#pragma once
#include "clients/ClientRepository.h"
#include "notification/Mailer.h"

#include <string>


class BirthdayService {
    protected:  
        ClientRepository *repository;
        Mailer *mailer;
    public:
        BirthdayService(ClientRepository& withRepository, Mailer& mailer);
        void greeting(std::string name) const;
};
