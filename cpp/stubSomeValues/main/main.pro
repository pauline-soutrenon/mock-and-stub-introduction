#-------------------------------------------------
#
# Project created by QtCreator 2016-04-12T09:14:31
#
#-------------------------------------------------

QT       -= gui

TARGET = main
TEMPLATE = lib
CONFIG += staticlib

SOURCES += \
    clients/ClientRepository.cpp \
    kata/BirthdayService.cpp

HEADERS += \
    clients/ClientRepository.h \
    kata/BirthdayService.h
unix {
    target.path = /usr/lib
    INSTALLS += target
}
