package kz.satbayev.contactbook.service.contact.contactparams;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StrategyDefiner {
    private final List<ContactSearchStrategy> searchStrategies;

    public ContactSearchStrategy defineStrategy(ContactFindParam param){
        return searchStrategies.stream()
                .filter(s -> s.supports(param.getSearchType()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unsupported search type"));
    }
}
