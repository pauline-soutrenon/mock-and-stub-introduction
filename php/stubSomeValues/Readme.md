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

### Code coverage
Check that you've covered everything with 

    php bin/phpunit --coverage-html report/

Then open report/index.html in a browser. For instance

    open report/index.html       # MacOS
    firefox report/index.html    # windows/linux
