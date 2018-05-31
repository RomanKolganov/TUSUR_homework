import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import services.DataPeekService;
import services.DataSendService;

@Configuration
public class InjectionContext {
    @Bean
    public DataPeekService peekService() {
        return new DataPeekService();
    }

    @Bean
    public DataSendService sendService() {
        return new DataSendService();
    }
}
