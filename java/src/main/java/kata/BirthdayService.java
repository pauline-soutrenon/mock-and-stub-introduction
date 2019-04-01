package kata;

import notification.Mailer;
import clients.ClientRepository;

public class BirthdayService {
  
  private ClientRepository repository;
  private Mailer mailer;

  public BirthdayService(ClientRepository repository, Mailer mailer) {
    this.repository = repository;
    this.mailer = mailer;
    
  }
  
  public void greeting(String name) {
    
    String greeting;
    
    if (repository.birthdayIsTodayFor(name)) {
      greeting = "Happy birthday " + name + "!";
    } else {
      greeting = "Good morning " + name + ".";
    }
    
    mailer.send(greeting);
    
  }

}
