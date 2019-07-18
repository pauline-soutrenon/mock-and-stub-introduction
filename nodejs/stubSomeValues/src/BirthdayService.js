"use strict"

class BirthdayService {

    constructor(clientRepository) {
        this.repository = clientRepository
    }

    greeting(name) {

        let greeting

        const isBirthday = this.repository.birthdayIsTodayFor(name)
        if (isBirthday) {
            greeting = "Happy birthday " + name + "!"
        } else {
            greeting = "Good morning " + name + "."
        }
        return greeting

    }
}

module.exports = BirthdayService
