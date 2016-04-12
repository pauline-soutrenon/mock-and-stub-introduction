#pragma once
#include "clients/ClientRepository.h"

#include <string>


class BirthdayService {
    protected:  
        ClientRepository *repository;
    public:
        BirthdayService(ClientRepository& withRepository);
        std::string greeting(std::string name) const;
};
