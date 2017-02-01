class BirthdayService {

    constructor(clientRepository){
        this.repository = clientRepository
    }

    greeting(name) {

        let greeting

        if (this.repository.birthdayIsTodayFor(name)) {
            greeting = "Happy birthday " + name + "!"
        } else {
            greeting = "Good morning " + name + "."
        }

        return greeting

    }
}
module.exports = BirthdayService
