## Configure the project in the IDE
Command line or from IDE

    composer install --dev
    composer dumpautoload

### Specific for Netbeans
* Run -> Project configuration -> 
  * "project dirname"/php/test
  * check "Phpunit"

* Options - > PHP 
  * composer, specify exec
  * phpunit, specify exec

Now you can run the tests. Run -> Test Project

