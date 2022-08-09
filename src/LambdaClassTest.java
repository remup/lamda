import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class LambdaClassTest {

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>(Arrays.asList("remya", "sonam"));
		FunctionaIntf a = () -> {
			System.out.println("hii functional interface");
		};
		Consumer<String> a2 = (i) -> {
			System.out.println(i + "  hii Consumer interface");
		};
		a.test();
		l.forEach(a2);
		l.forEach((i) -> {
			System.out.println(i + "  hii Consumer interface direct");
		});
		List<String> l2 = l.stream().filter(d -> d.equals("remya")).collect(Collectors.toList());
		System.out.println("after list removal");
		l.forEach(a2);
		l2.forEach(a2);

		List<LamdaClass> lamdaClassList = new ArrayList<LamdaClass>(
				Arrays.asList(new LamdaClass(1, "lamdaClassName1"), new LamdaClass(2, "lamdaClassName2")));
		Map<Integer, String> map = lamdaClassList.stream()
				.collect(Collectors.toMap(LamdaClass::getNumber, LamdaClass::getName));

		map.forEach((key, value) -> {
			System.out.println("map key " + key + "  map value  " + value);
		});

		List<Integer> lamdaClassList2 = map.keySet().stream().collect(Collectors.toList());
		lamdaClassList2.forEach((d) -> System.out.println(d));

		map.entrySet().forEach(System.out::println);

	}

}
