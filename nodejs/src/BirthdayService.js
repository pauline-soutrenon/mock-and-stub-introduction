"use strict";

class BirthdayService {

    constructor(clientRepository, mailer){
        this.repository = clientRepository
        this.mailer = mailer
    }

    greeting(name) {


        return this.repository.birthdayIsTodayFor(name)
            .then(isBirthday => {
                let greeting

                if (isBirthday) {
                    greeting = "Happy birthday " + name + "!"
                } else {
                    greeting = "Good morning " + name + "."
                }

                this.mailer.send(greeting)

            });

    }
}
module.exports = BirthdayService
