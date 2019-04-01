class Mailer {
    send(greeting) {
        throw new Error('should not be called in unit test because it invokes SMTP or webservices')
    }
}