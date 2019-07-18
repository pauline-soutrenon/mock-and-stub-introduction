"use strict";

var expect = require('chai').expect;
let sinon = require('sinon')

describe('BirthdayService', function () {
    var BirthdayService = require('../src/BirthdayService');

    describe('greeting()', function () {
        it('good morning', function () {
            // Given
            const repository = {
                birthdayIsTodayFor: sinon.stub()
            }
            const mailer = {
                send: sinon.spy()
            }
            const b = new BirthdayService(repository, mailer)

            // When
            b.greeting('fred')

            // Then
            sinon.assert.calledWith(mailer.send, "Good morning fred.");
        });
        it('happy birthday', function () {
            // Given
            const repository = {
                birthdayIsTodayFor: sinon.stub()
            }
            repository.birthdayIsTodayFor.returns(true)
            const mailer = {
                send: sinon.spy()
            }
            const b = new BirthdayService(repository, mailer)

            // When
            b.greeting('fred')

            // Then
            sinon.assert.calledWith(mailer.send, "Happy birthday fred!");
        });
        it('happy birthday with matchers', function () {
            // Given
            const repository = {
                birthdayIsTodayFor: sinon.stub()
            }
            repository.birthdayIsTodayFor.returns(true)
            const mailer = {
                send: sinon.spy()
            }
            const b = new BirthdayService(repository, mailer)

            // When
            b.greeting('fred')

            // Then
            sinon.assert.calledWith(mailer.send, sinon.match(/Happy.*?/));
        });
        it('happy birthday', function () {
            // Given
            const repository = {
                birthdayIsTodayFor: sinon.stub()
            }
            repository.birthdayIsTodayFor.returns(true)
            const mailer = {
                send: sinon.spy()
            }
            const b = new BirthdayService(repository, mailer)

            // When
            b.greeting('fred')

            // Then
            let greeting = mailer.send.firstCall.args[0]
            expect(greeting).include("Happy birthday")
        });
    });
});