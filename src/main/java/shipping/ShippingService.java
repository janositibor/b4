package shipping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShippingService {
    private List<Transportable> packages=new ArrayList<>();

    public void addPackage(Transportable transportable){
        packages.add(transportable);
    }
    public List<Transportable> collectItemsByBreakableAndWeight(boolean breakable, int weight){
        return packages.stream()
                .filter(p->(p.isBreakable()==breakable))
                .filter(p->p.getWeight()>=weight)
                .toList();
    }
    public Map<String, Long> collectTransportableByCountry(){
        return packages.stream()
                .collect(Collectors.groupingBy(Transportable::getDestinationCountry,Collectors.counting()));
    }
    public List<Transportable> sortInternationalPackagesByDistance() {
        return packages.stream()
                .filter(t->t.getClass().equals(InternationalPackage.class))
                .sorted(Comparator.comparingInt(t->((InternationalPackage) t).getDistance()))
                .toList();
    }
    public List<Transportable> getPackages() {
        return packages;
    }

}
