"use strict";

var expect = require('chai').expect;
let sinon = require('sinon')

describe('BirthdayService', function() {
    var BirthdayService = require('../src/BirthdayService');
    var clientRepository;
    let b;
    describe('greeting()', function() {
        beforeEach(function () {
            clientRepository = {
                birthdayIsTodayFor: sinon.stub()
            };
            b = new BirthdayService(clientRepository);
        });
        it('false', function() {
            clientRepository.birthdayIsTodayFor.withArgs('fred').returns(false)
            const s = b.greeting('fred')
            expect(s).equal('Good morning fred.')
        });
        it('is fred birthday', function() {
            clientRepository.birthdayIsTodayFor.withArgs('fred').returns(true)
            const s = b.greeting('fred')
            expect(s).equal('Happy birthday fred!')
        });
        it('is not sandra birthday', function() {
            clientRepository.birthdayIsTodayFor.withArgs('fred').returns(true)
            const s = b.greeting('sandra')
            expect(s).equal('Good morning sandra.')
        });
    });
});