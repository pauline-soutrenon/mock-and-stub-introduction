#pragma once

#include <string>

class ClientRepository {
    public:
    virtual bool birthdayIsTodayFor(const std::string& name) const;

};
