"use strict";

class ClientRepository {

    birthdayIsTodayFor(personName) {
        throw new Error('should not be called in a unit test')
    }
}

module.exports = ClientRepository