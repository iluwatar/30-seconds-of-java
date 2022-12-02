# 30 Seconds of Java

30 Seconds of Java는 30초 안에 이해 가능한 Java 11 코드를 모아놓은 프로젝트 입니다. 이 프로젝트는 [30 seconds of code](https://github.com/Chalarangelo/30-seconds-of-code)에서 영감을 받아 만들어졌습니다. 코드 기여를 하실 때는 [instructions](https://github.com/iluwatar/30-seconds-of-java/blob/master/CONTRIBUTE.md) 문서를 참고하여 주시길 바랍니다.   



## 알고리즘

### 퀵 정렬(Quicksort)

```java
  public static void quickSort(int[] arr, int left, int right) {
    var pivotIndex = left + (right - left) / 2;
    var pivotValue = arr[pivotIndex];
    var i = left;
    var j = right;
    while (i <= j) {
      while (arr[i] < pivotValue) {
        i++;
      }
      while (arr[j] > pivotValue) {
        j--;
      }
      if (i <= j) {
        var tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        i++;
        j--;
      }
      if (left < i) {
        quickSort(arr, left, j);
      }
      if (right > i) {
        quickSort(arr, i, right);
      }
    }
  }
```

### 버블 정렬(Bubblesort)

```java
  public static void bubbleSort(int[] arr) {
    var lastIndex = arr.length - 1;

    for(var j = 0; j < lastIndex; j++) {
      for(var i = 0; i < lastIndex - j; i++) {
        if(arr[i] > arr[i + 1]) {
          var tmp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = tmp;
        }
      }
    }
  }
```

### 선택 정렬(Selectionsort)

```java
  public static void selectionSort(int[] arr) {
    var len = arr.length;
        
    for (var i = 0; i < len - 1; i++) {
      var minIndex = i;
        
      for (var j = i + 1; j < len; j++) {
        if(arr[j] < arr[minIndex])
          minIndex = j;
      }
        
      var tmp = arr[minIndex];
      arr[minIndex] = arr[i];
      arr[i] = tmp;
    }
  }
```

### 삽입 정렬(InsertionSort)

```java
  public static void insertionSort(int[] arr) {
    for (var i = 1; i < arr.length; i++) {
      var tmp = arr[i];
      var j = i - 1;

      while (j >= 0 && arr[j] > tmp) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = tmp;
    }
  }
```

### 계수 정렬(CountingSort)
```java
  public static void countingSort(int[] arr) {
    var max = Arrays.stream(arr).max().getAsInt();

    var count = new int[max + 1];

    for (var num : arr) {
      count[num]++;
    }

    for (var i = 1; i <= max; i++) {
      count[i] += count[i - 1];
    }

    var sorted = new int[arr.length];
    for (var i = arr.length - 1; i >= 0; i--) {
      var cur = arr[i];
      sorted[count[cur] - 1] = cur;
      count[cur]--;
    }

    var index = 0;
    for (var num : sorted) {
      arr[index++] = num;
    }
  }
```

## 배열

### 두 개의 배열 연결 

```java
  public static <T> T[] arrayConcat(T[] first, T[] second) {
    var result = Arrays.copyOf(first, first.length + second.length);
    System.arraycopy(second, 0, result, first.length, second.length);
    return result;
  }
```

### N 개의 배열 연결 

```java
  public static <T> T[] nArrayConcat(T[] first, T[]... rest) {
    var totalLength = first.length;
    for (var array : rest) {
      totalLength += array.length;
    }
    var result = Arrays.copyOf(first, totalLength);
    var offset = first.length;
    for (var array : rest) {
      System.arraycopy(array, 0, result, offset, array.length);
      offset += array.length;
    }
    return result;
  }
```

### 어레이의 모든 요소가 동일한지 확인 

```java
  public static <T> boolean allEqual(T[] arr) {
    return Arrays.stream(arr).distinct().count() == 1;
  }
```

### 배열의 평균 값

```java
  public static double arrayMean(int[] arr) {
    return (double) Arrays.stream(arr).sum() / arr.length;
  }
```

### 배열의 중앙값

```java
  public static double arrayMedian(int[] arr) {
    Arrays.sort(arr);
    var mid = arr.length / 2;
    return arr.length % 2 != 0 ? (double) arr[mid] : (double) (arr[mid] + arr[mid - 1]) / 2;
  }
```

### 배열의 합 

```java
  public static int arraySum(int[] arr) {
    return Arrays.stream(arr).sum();
  }
```

### 배열의 최댓값

```java
  public static int findMax(int[] arr) {
    return Arrays.stream(arr).reduce(Integer.MIN_VALUE, Integer::max);
  }
```

## 인코딩 

### Base64 인코딩  

```java
  public static String encodeBase64(String input) {
    return Base64.getEncoder().encodeToString(input.getBytes());
  }
```

### Base64 디코딩 

```java
  public static String decodeBase64(String input) {
    return new String(Base64.getDecoder().decode(input.getBytes()));
  }
```

## 파일 

### 디렉토리 목록 가져오기 

```java
  public static File[] listDirectories(String path) {
    return new File(path).listFiles(File::isDirectory);
  }
```

### 디렉토리의 파일 리스트 가져오기 

```java
  public static File[] listFilesInDirectory(final File folder) {
    return folder.listFiles(File::isFile);
  }
```

### 재귀적으로 디렉토리의 파일 리스트 가져오기

```java
  public static List<File> listAllFiles(String path) {
    var all = new ArrayList<File>();
    var list = new File(path).listFiles();

    if (list != null) {  // list가 null일 시 오류 발생  
      for (var f : list) {
        if (f.isDirectory()) {
          all.addAll(listAllFiles(f.getAbsolutePath()));
        } else {
          all.add(f.getAbsoluteFile());
        }
      }
    }
    return all;
  }
```

### 파일을 읽고 String 리스트에 저장 

```java
  public static List<String> readLines(String filename) throws IOException {
    return Files.readAllLines(new File(filename).toPath());
  }
```

### 파일 압축하기 

```java
  public static void zipFile(String srcFilename, String zipFilename) throws IOException {
    var srcFile = new File(srcFilename);
    try (
            var fileOut = new FileOutputStream(zipFilename);
            var zipOut = new ZipOutputStream(fileOut);
            var fileIn = new FileInputStream(srcFile);
    ) {
      var zipEntry = new ZipEntry(srcFile.getName());
      zipOut.putNextEntry(zipEntry);
      final var bytes = new byte[1024];
      int length;
      while ((length = fileIn.read(bytes)) >= 0) {
        zipOut.write(bytes, 0, length);
      }
    }
  }
```

### 파일 여러개 압축하기 

```java
  public static void zipFiles(String[] srcFilenames, String zipFilename) throws IOException {
    try (
      var fileOut = new FileOutputStream(zipFilename);
      var zipOut = new ZipOutputStream(fileOut);
    ) {
      for (var i=0; i<srcFilenames.length; i++) {
        var srcFile = new File(srcFilenames[i]);
        try (var fileIn = new FileInputStream(srcFile)) {
          var zipEntry = new ZipEntry(srcFile.getName());
          zipOut.putNextEntry(zipEntry);
          final var bytes = new byte[1024];
          int length;
          while ((length = fileIn.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
          }
        }
      }
    }
  }
```

### 디렉토리 압축하기 

```java
  public static void zipDirectory (String srcDirectoryName, String zipFileName) throws IOException {
    var srcDirectory = new File(srcDirectoryName);
    try (
      var fileOut = new FileOutputStream(zipFileName);
      var zipOut = new ZipOutputStream(fileOut)
    ) {
      zipFile(srcDirectory, srcDirectory.getName(), zipOut);
    }
  }
  public static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) 
      throws IOException {
    if (fileToZip.isHidden()) { // 숨겨진 파일들은 무시하도록 설정되어있음
      return;
    }
    if (fileToZip.isDirectory()) {
      if (fileName.endsWith("/")) {
        zipOut.putNextEntry(new ZipEntry(fileName)); // 나중에 압축되어야함 
        zipOut.closeEntry();
      } else {
        // 압축 해제 작업이 수행되는 동안 구조를 유지하기 위해 명시적으로 역슬래시 "/" 부호 추가 
        zipOut.putNextEntry(new ZipEntry(fileName + "/"));
        zipOut.closeEntry();
      }
      var children = fileToZip.listFiles();
      for (var childFile : children) { // Recursively apply function to all children
        zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
      }
      return;
    }
    try (
        var fis = new FileInputStream(fileToZip) // 파일일 시 압축 시작
    ) {
      var zipEntry = new ZipEntry(fileName);
      zipOut.putNextEntry(zipEntry);
      var bytes = new byte[1024];
      var length = 0;
      while ((length = fis.read(bytes)) >= 0) {
        zipOut.write(bytes, 0, length);
      }
    }
  }
```

## 수학

### 재귀함수를 활용한 피보나치

```java
  public static int fibonacci(int n) {
    if (n <= 1) {
      return n;
    } else {
      return fibonacci(n - 1) + fibonacci(n - 2);
    }
  }
```

### 피보나치 반복문으로 처리  

```java
  public static int iterativeFibonacci(int number) {
    List<Integer> list = new ArrayList<>();
    list.add(0);
    list.add(1);
    for (int i = 2; i < number + 1; i++) {
      list.add(list.get(i - 2) + list.get(i - 1));
    }
    return list.get(number);
  }
```

### 팩토리얼

```java
  public static int factorial(int number) {
    var result = 1;
    for (var factor = 2; factor <= number; factor++) {
      result *= factor;
    }
    return result;
  }
```

### 재귀 함수를 활용한 팩토리얼

```java
  public static int recursiveFactorial(int number) {
    var initial = 0;
    if (number == initial) {
      return initial + 1;
    }
    return number * recursiveFactorial(number - 1);
  }
```

### 하버사인 공식 

```java
  // 지구 반지름 KM
  private static final double SPHERE_RADIUS_IN_KM = 6372.8;

  public static double findHaversineDistance(double latA, double longA, double latB, double longB) {
    if (!isValidLatitude(latA)
        || !isValidLatitude(latB)
        || !isValidLongitude(longA)
        || !isValidLongitude(longB)) {
      throw new IllegalArgumentException();
    }

    // 위도와 경도 차이 계산 
    var latitudeDiff = Math.toRadians(latB - latA);
    var longitudeDiff = Math.toRadians(longB - longA);

    var latitudeA = Math.toRadians(latA);
    var latitudeB = Math.toRadians(latB);

    // 하버 사인 공식을 통해 두 개의 좌표 사이의 거리 구하기   
    var a = Math.pow(Math.sin(latitudeDiff / 2), 2)
            + Math.pow(Math.sin(longitudeDiff / 2), 2) * Math.cos(latitudeA) * Math.cos(latitudeB);
    var c = 2 * Math.asin(Math.sqrt(a));
    return SPHERE_RADIUS_IN_KM * c;
  }

  // 올바른 위도값인지 확인 
  private static boolean isValidLatitude(double latitude) {
    return latitude >= -90 && latitude <= 90;
  }

  // 올바른 경도값인지 확인 
  private static boolean isValidLongitude(double longitude) {
    return longitude >= -180 && longitude <= 180;
  }
```

### 로또 

```java
  public static Integer[] performLottery(int numNumbers, int numbersToPick) {
    var numbers = new ArrayList<Integer>();
    for(var i = 0; i < numNumbers; i++) {
      numbers.add(i+1);
    }

    Collections.shuffle(numbers);
    return numbers.subList(0, numbersToPick).toArray(new Integer[numbersToPick]);
  }
```

### 룬(Luhn) 알고리즘
```java
public static int calculateLuhnChecksum(long num) {
    if (num < 0) {
      throw new IllegalArgumentException("Non-negative numbers only.");
    }
    final var numStr = String.valueOf(num);

    var sum = 0;
    var isOddPosition = true;
    // numStr의 숫자를 오른쪽에서 왼쪽(끝에서 처음) 방향으로 반복 
    for (var i = numStr.length() - 1; i >= 0; i--) {
      final var digit = Integer.parseInt(Character.toString(numStr.charAt(i)));
      final var substituteDigit = (isOddPosition ? 2 : 1) * digit;

      final var tensPlaceDigit = substituteDigit / 10;
      final var onesPlaceDigit = substituteDigit % 10;
      sum += tensPlaceDigit + onesPlaceDigit;

      isOddPosition = !isOddPosition;
    }
    final var checksumDigit = (10 - (sum % 10)) % 10;
    // Outermost modulus handles edge case `num = 0`.
    return checksumDigit;
  }
```

### 최대공약수(GCD)

```java
  public static int gcd(int a, int b) { 
    if (b == 0) 
      return a; 
    return gcd(b, a % b);  
  }
```

### 소수

```java
  public static boolean isPrime(int number) {
    if (number < 3) {
      return true;
    }

    // n이 짝수인지 확인 
    if (number % 2 == 0) {
      return false;
    }

    // 짝수가 아니라면 홀수인지 확인 
    for (var i = 3; i * i <= number; i += 2) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }
```

### 이진법 

```java
  public static String toBinary(long naturalNumber) {
    if (naturalNumber < 0) {
      throw new NumberFormatException("Negative Integer, this snippet only accepts "
              + "positive integers");
    }
    if (naturalNumber == 0) {
      return "0";
    }
    final Stack<Long> binaryBits =
            Stream.iterate(naturalNumber, n -> n > 0, n -> n / 2).map(n -> n % 2)
                    .collect(Stack::new, Stack::push, Stack::addAll);
    return Stream.generate(binaryBits::pop)
            .limit(binaryBits.size()).map(String::valueOf).collect(Collectors.joining());
  }
  
  public static Long fromBinary(String binary) {
    binary.chars().filter(c -> c != '0' && c != '1').findFirst().ifPresent(in -> {
      throw new NumberFormatException(
              "Binary string contains values other than '0' and '1'");
    });
    return IntStream.range(0, binary.length())
            .filter(in -> binary.charAt(binary.length() - 1 - in) == '1')
            .mapToLong(in -> ((long) 0b1) << in).sum();
  }
  
```

## 미디어

### 화면 캡쳐 

```java
  public static void captureScreen(String filename) throws AWTException, IOException {
    var screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    var screenRectangle = new Rectangle(screenSize);
    var robot = new Robot();
    var image = robot.createScreenCapture(screenRectangle);
    ImageIO.write(image, "png", new File(filename));
  }
```

## Networking

### HTTP GET

```java
  public static HttpResponse<String> httpGet(String uri) throws Exception {
    var client = HttpClient.newHttpClient();
    var request = HttpRequest.newBuilder()
            .uri(URI.create(uri))
            .build();
    return client.send(request, BodyHandlers.ofString());
  }
```

### HTTP POST

```java
  public static HttpResponse<String> httpPost(String address, HashMap<String,String> arguments) 
    throws IOException, InterruptedException {
    var sj = new StringJoiner("&");
    for(var entry : arguments.entrySet()) {
      sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "="
              + URLEncoder.encode(entry.getValue(), "UTF-8"));
    }

    var out = sj.toString().getBytes(StandardCharsets.UTF_8);
    var request = HttpRequest.newBuilder()
            .uri(URI.create(address))
            .headers("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
            .POST(BodyPublishers.ofByteArray(out))
            .build();

    return HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
  }
```

## 문자열

### 팰린드롬 알고리즘 

```java
  public static boolean isPalindrome(String s) {
    var sb = new StringBuilder();
    for (var c : s.toCharArray()) {
      if (Character.isLetter(c)) {
        sb.append(c);
      }
    }

    var forward = sb.toString().toLowerCase();
    var backward = sb.reverse().toString().toLowerCase();
    return forward.equals(backward);
  }
```

### 문자열 뒤집기 

```java
  public static String reverseString(String s) {
    return new StringBuilder(s).reverse().toString();
  }
```

### 문자열을 date(날짜) 타입으로 변환 

```java
  public static Date stringToDate(String date, String format) throws ParseException {
    var simpleDateFormat = new SimpleDateFormat(format);
    return simpleDateFormat.parse(date);
  }
```

### 아나그램 체크 

```java
  public boolean isAnagram(String s1, String s2) { 
    var l1 = s1.length();
    var l2 = s2.length();
    var arr1 = new int[256];
    var arr2 = new int[256];
    if (l1 != l2) {
      return false;
    }
    
    for (var i = 0; i < l1; i++) {
      arr1[s1.charAt(i)]++;
      arr2[s2.charAt(i)]++;
    }

    return Arrays.equals(arr1, arr2);
  }
```

### 레벤슈타인 거리 찾기 

```java
  public static int findLevenshteinDistance(String word1, String word2) {
    // word2 문자열이 비어있을 시, 삭제 
    int[][] ans = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i <= word1.length(); i++) {
      ans[i][0] = i;
    }

    // word1 문자열이 비어있을 시, 추가 
    for (int i = 0; i <= word2.length(); i++) {
      ans[0][i] = i;
    }

    // 빈 문자열이 없을 때 
    for (int i = 1; i <= word1.length(); i++) {
      for (int j = 1; j <= word2.length(); j++) {
        int min = Math.min(Math.min(ans[i][j - 1], ans[i - 1][j]), ans[i - 1][j - 1]);
        ans[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? ans[i - 1][j - 1] : min + 1;
      }
    }
    return ans[word1.length()][word2.length()];
  }
```

### 버전 비교 

```java
  public static int compareVersion(String v1, String v2) {
    Function<String, String[]> getVersionComponents = version -> version.replaceAll(".*?((?<!\\w)\\d+([.-]\\d+)*).*", "$1", "$1").split("\\.");

    var components1 = getVersionComponents.apply(v1);
    var components2 = getVersionComponents.apply(v2);
    int length = Math.max(components1.length, components2.length);

    for (int i = 0; i < length; i++) {
      Integer c1 = i < components1.length ? Integer.parseInt(components1[i]) : 0;
      Integer c2 = i < components2.length ? Integer.parseInt(components2[i]) : 0;
      int result = c1.compareTo(c2);
      if (result != 0) {
        return result;
      }
    }
    return 0;
  }
```

## 클래스

### 메소드 이름 

```java
  public static List<String> getAllMethods(final Class<?> cls) {
    return Arrays.stream(cls.getDeclaredMethods())
            .map(Method::getName)
            .collect(Collectors.toList());
  }
```

### 퍼블릭 필드 이름들 가져오기 

```java
  public static List<String> getAllFieldNames(final Class<?> cls) {
    return Arrays.stream(cls.getFields())
            .map(Field::getName)
            .collect(Collectors.toList());
  }
```

### 모든 필드 이름들 가져오기 

```java
  public static List<String> getAllFieldNames(final Class<?> cls) {
      var fields = new ArrayList<String>();
      var currentCls = cls;
      while (currentCls != null) {
        fields.addAll(
            Arrays.stream(currentCls.getDeclaredFields())
                .filter(field -> !field.isSynthetic())
                .map(Field::getName)
                .collect(Collectors.toList()));
        currentCls = currentCls.getSuperclass();
      }
      return fields;
    }
```

### Object 생성 

```java
  public static Object createObject(String cls)
            throws NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException,
            ClassNotFoundException {
    var objectClass = Class.forName(cls);
    var objectConstructor = objectClass.getConstructor();
    return objectConstructor.newInstance();
  }
```


## I/O

### Stream을 통해 파일 읽기 

```java
  public static List<String> readFile(String fileName) throws FileNotFoundException {
    try (Stream<String> stream = new BufferedReader(new FileReader(fileName)).lines()) {
      return stream.collect(Collectors.toList());
    }
  }
```

### InputStream을 문자열로 

```java
  public static String inputStreamToString(InputStream inputStream) throws IOException {
    try (var reader = new BufferedReader(new InputStreamReader(inputStream))) {
      var stringBuilder = new StringBuilder();
      var data = reader.read();
 
      while (data != -1) {
        stringBuilder.append((char) data);
        data = reader.read();
      }
      return stringBuilder.toString();
    }
  }
```


## 쓰레드

### 쓰레드 풀 생성 

```java
  public static ExecutorService createFixedThreadPool() {
    return Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
  }
```

## 날짜 

### 현재 날짜 
```java
  public static Date addDaysToDate(Date date, int noOfDays){
    if(date!=null){
      Calendar cal = Calendar.getInstance();
      cal.setTime(date);
      cal.add(Calendar.DAY_OF_MONTH, noOfDays);
      return cal.getTime();
    }
    return null;
   }
```


### 로컬 날짜 
```java
 public static LocalDate addDaysToLocalDate(LocalDate date, long noOfDays){
    return date!=null ? date.plusDays(noOfDays) : null;
 }
```

