<?php

namespace verifySomeBehavior;

use PHPUnit\Framework\TestCase;
use Prophecy\Prophet;

class BirthdayServiceTest extends TestCase
{

    /** @test */
    public function wishesHappyBirthdayOnTheDay()
    {

        $mailerProphecy = $this->prophesize(Mailer::class);
        $repositoryProphecy = $this->prophesize(ClientRepository::class);

        $service = new BirthdayService($repositoryProphecy->reveal(), $mailerProphecy->reveal());

        $service->greetingFor("Cloe");

        $mailerProphecy->send('Good morning Cloe.')->shouldBeCalled();
    }
    
    /** @test */
    public function simplySaysGoodMorningOnOtherDays()
    {

        $mailerProphecy = $this->prophesize(Mailer::class);
        $repositoryProphecy = $this->prophesize(ClientRepository::class);
        $repositoryProphecy->birthDayIsTodayFor("Cloe")->willReturn(true);

        $service = new BirthdayService($repositoryProphecy->reveal(), $mailerProphecy->reveal());

        $service->greetingFor("Cloe");

        $mailerProphecy->send('Happy birthday Cloe!')->shouldBeCalled();
    }



}
