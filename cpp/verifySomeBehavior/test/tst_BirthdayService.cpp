#include <QString>
#include <QtTest>

class BirthdayServiceTest : public QObject
{
    Q_OBJECT

public:
    BirthdayServiceTest();

private Q_SLOTS:
    void testCase1();
};

BirthdayServiceTest::BirthdayServiceTest()
{
}

void BirthdayServiceTest::testCase1()
{
    QVERIFY2(true, "Failure");
}

QTEST_APPLESS_MAIN(BirthdayServiceTest)

#include "tst_BirthdayService.moc"
