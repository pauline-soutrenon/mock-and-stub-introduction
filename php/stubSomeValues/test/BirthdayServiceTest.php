<?php

namespace stubSomeValues;

use PHPUnit\Framework\TestCase;
use Prophecy\Prophet;

class BirthdayServiceTest extends TestCase
{
    /** @test */
    public function wishesHappyBirthdayOnTheDay()
    {
        $prophecy = $this->newProphecy();
        $prophecy->birthDayIsTodayFor("Arnaud")->willReturn(true);
        $birthdayService = new BirthdayService($prophecy->reveal());

        $this->assertEquals("Happy birthday Arnaud!", $birthdayService->greetingFor("Arnaud"));
    }

    /** @test */
    public function simplySaysGoodMorningOnOtherDays()
    {
        $prophecy = $this->newProphecy();
        $prophecy->birthDayIsTodayFor("Fred")->willReturn(false);
        $birthdayServier = new BirthdayService($prophecy->reveal());

        $greeting = $birthdayServier->greetingFor("Fred");

        $this->assertEquals("Good morning Fred.", $greeting);

    }


    /**
     * @return \Prophecy\Prophecy\ObjectProphecy
     */
    private function newProphecy(): \Prophecy\Prophecy\ObjectProphecy
    {
        $prophecy = (new Prophet())->prophesize(ClientRepository::class);
        return $prophecy;
    }


}
