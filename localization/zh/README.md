# 30秒快速编码

灵感来源: [30秒快速编码](https://github.com/Chalarangelo/30-seconds-of-code), 这是一组可重复使用的、经过测试的、可粘贴的Java17兼容代码片段，您可以在30秒内或更短的时间内理解这些代码片段。 如果您有兴趣对此库进行贡献，请参阅 [贡献说明](https://github.com/iluwatar/30-seconds-of-java/blob/master/CONTRIBUTE.md).

## 算法

### 快速排序

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

### 冒泡排序

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

### 选择排序

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

### 插入排序

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

### 计数排序
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

## 数组

### 通用双数组串联

```java
  public static <T> T[] arrayConcat(T[] first, T[] second) {
    var result = Arrays.copyOf(first, first.length + second.length);
    System.arraycopy(second, 0, result, first.length, second.length);
    return result;
  }
```

### 通用多数组串联

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

### 计算数组的所有元素是否相等

```java
  public static <T> boolean allEqual(T[] arr) {
    return Arrays.stream(arr).distinct().count() == 1;
  }
```

### 计算整数数组的平均值

```java
  public static double arrayMean(int[] arr) {
    return (double) Arrays.stream(arr).sum() / arr.length;
  }
```

### 计算整数数组的中值

```java
  public static double arrayMedian(int[] arr) {
    Arrays.sort(arr);
    var mid = arr.length / 2;
    return arr.length % 2 != 0 ? (double) arr[mid] : (double) (arr[mid] + arr[mid - 1]) / 2;
  }
```
### Mode in Array

```java
    public static int modeArray(int arr[])
    {
    int mode=0,maxcount=0;

        for(int i=0;i<arr.length;i++)
        {
            int count=0;

            for(int j=0;j<arr.length;j++)
            {
                if(arr[i]==arr[j])
                    count++;
            }
            if(count>maxcount)
            {
                maxcount=count;
                mode=arr[i];
            }
        }
        return mode;
    }

```

### 计算整数数组的和

```java
  public static int arraySum(int[] arr) {
    return Arrays.stream(arr).sum();
  }
```

### 计算整数数组的最大值

```java
  public static int findMax(int[] arr) {
    return Arrays.stream(arr).reduce(Integer.MIN_VALUE, Integer::max);
  }
```

## 编码

### Base64编码字符串

```java
  public static String encodeBase64(String input) {
    return Base64.getEncoder().encodeToString(input.getBytes());
  }
```

### Base64解码字符串

```java
  public static String decodeBase64(String input) {
    return new String(Base64.getDecoder().decode(input.getBytes()));
  }
```

## 文件

### 列出目录

```java
  public static File[] listDirectories(String path) {
    return new File(path).listFiles(File::isDirectory);
  }
```

### 列出目录中的文件

```java
  public static File[] listFilesInDirectory(final File folder) {
    return folder.listFiles(File::isFile);
  }
```

### 递归列出目录中的文件

```java
  public static List<File> listAllFiles(String path) {
    var all = new ArrayList<File>();
    var list = new File(path).listFiles();

    if (list != null) {  // 访问错误时, list为null
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

### 将文件中的行读取到字符串列表

```java
  public static List<String> readLines(String filename) throws IOException {
    return Files.readAllLines(new File(filename).toPath());
  }
```

### 压缩单个文件为Zip文件

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

### 压缩多个文件为Zip文件

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

### 压缩文件夹为Zip文件

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
    if (fileToZip.isHidden()) { // 忽略隐藏的文件
      return;
    }
    if (fileToZip.isDirectory()) {
      if (fileName.endsWith("/")) {
        zipOut.putNextEntry(new ZipEntry(fileName)); // 稍后压缩
        zipOut.closeEntry();
      } else {
        // 在执行解压缩操作时，显式添加"/"标记以保留结构
        zipOut.putNextEntry(new ZipEntry(fileName + "/"));
        zipOut.closeEntry();
      }
      var children = fileToZip.listFiles();
      for (var childFile : children) { // 递归地将函数应用于所有子级
        zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
      }
      return;
    }
    try (
        var fis = new FileInputStream(fileToZip) // 只能是一个文件，开始压缩
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

## 数学

### Even or Odd

```java
    public static String evenodd(int num)
       {
           if(num%2==0)
                return "even";
           else
               return "odd";
       }

```

### 斐波那契

```java
  public static int fibonacci(int n) {
    if (n <= 1) {
      return n;
    } else {
      return fibonacci(n - 1) + fibonacci(n - 2);
    }
  }
```

### 迭代斐波那契

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

### 阶乘

```java
  public static int factorial(int number) {
    var result = 1;
    for (var factor = 2; factor <= number; factor++) {
      result *= factor;
    }
    return result;
  }
```

### 递归阶乘

```java
  public static int recursiveFactorial(int number) {
    var initial = 0;
    if (number == initial) {
      return initial + 1;
    }
    return number * recursiveFactorial(number - 1);
  }
```

### 半正矢公式

```java
  // 点所在的球体半径，在本例中为地球
  private static final double SPHERE_RADIUS_IN_KM = 6372.8;

  public static double findHaversineDistance(double latA, double longA, double latB, double longB) {
    if (!isValidLatitude(latA)
        || !isValidLatitude(latB)
        || !isValidLongitude(longA)
        || !isValidLongitude(longB)) {
      throw new IllegalArgumentException();
    }

    // 计算纬度和经度差
    var latitudeDiff = Math.toRadians(latB - latA);
    var longitudeDiff = Math.toRadians(longB - longA);

    var latitudeA = Math.toRadians(latA);
    var latitudeB = Math.toRadians(latB);

    // 根据哈弗辛公式(haversine)计算距离
    var a = Math.pow(Math.sin(latitudeDiff / 2), 2)
            + Math.pow(Math.sin(longitudeDiff / 2), 2) * Math.cos(latitudeA) * Math.cos(latitudeB);
    var c = 2 * Math.asin(Math.sqrt(a));
    return SPHERE_RADIUS_IN_KM * c;
  }

  // 检查有效纬度值
  private static boolean isValidLatitude(double latitude) {
    return latitude >= -90 && latitude <= 90;
  }

  // 检查有效的经度值
  private static boolean isValidLongitude(double longitude) {
    return longitude >= -180 && longitude <= 180;
  }
```

### 抽奖

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

### Luhn(模10)算法
```java
public static int calculateLuhnChecksum(long num) {
    if (num < 0) {
      throw new IllegalArgumentException("Non-negative numbers only.");
    }
    final var numStr = String.valueOf(num);

    var sum = 0;
    var isOddPosition = true;
    // 我们从右到左循环numStr中的数字。
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
### SquareRoot of a Number
```java
static double sqrt(int num,int p)  //p-precision(till how many decimal numbers we want)
    {
        int start=0,end=num;
        double root=0.0;

        while(start<=end)
        {
            int mid=start+(end-start)/2;

            if((mid*mid)>num)
                end=mid-1;
            else if((mid*mid)<num)
                start=mid+1;
            else
                return mid;
        }
        //root=end;
        double incr=0.1;

        for(int i=0;i<p;i++)
        {
            while(root*root < num)
                root=root+incr;

            root=root-incr;
            incr=incr/10;
        }

        return root;
    }
```

### 最大公约数

```java
  public static int gcd(int a, int b) { 
    if (b == 0) 
      return a; 
    return gcd(b, a % b);  
  }
```

### 素数

```java
  public static boolean isPrime(int number) {
    if (number < 3) {
      return true;
    }

    // 检查n是否为2的倍数
    if (number % 2 == 0) {
      return false;
    }

    // 如果没有，只看基数
    for (var i = 3; i * i <= number; i += 2) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }
```

### 自然数二进制转换

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

## 多媒体

### 截屏

```java
  public static void captureScreen(String filename) throws AWTException, IOException {
    var screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    var screenRectangle = new Rectangle(screenSize);
    var robot = new Robot();
    var image = robot.createScreenCapture(screenRectangle);
    ImageIO.write(image, "png", new File(filename));
  }
```

## 网络

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

## 字符串

### 回文检查

```java
  public static boolean isPalindrome(String s) {
    for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
      while (i < j && !Character.isLetter(s.charAt(i))) {
        i++;
      }
      while (i < j && !Character.isLetter(s.charAt(j))) {
        j--;
      }

      if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
        return false;
      }
    }

    return true;
  }
```

### 反转字符串

```java
  public static String reverseString(String s) {
    return new StringBuilder(s).reverse().toString();
  }
```

### 字符串转换到日期

```java
  public static Date stringToDate(String date, String format) throws ParseException {
    var simpleDateFormat = new SimpleDateFormat(format);
    return simpleDateFormat.parse(date);
  }
```

### 重组子串检查

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

### 计算Levenshtein距离

```java
  public static int findLevenshteinDistance(String word1, String word2) {
    // 如果word2为空，则删除
    int[][] ans = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i <= word1.length(); i++) {
      ans[i][0] = i;
    }

    // 如果word1为空，则添加
    for (int i = 0; i <= word2.length(); i++) {
      ans[0][i] = i;
    }

    // 都不为空
    for (int i = 1; i <= word1.length(); i++) {
      for (int j = 1; j <= word2.length(); j++) {
        int min = Math.min(Math.min(ans[i][j - 1], ans[i - 1][j]), ans[i - 1][j - 1]);
        ans[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? ans[i - 1][j - 1] : min + 1;
      }
    }
    return ans[word1.length()][word2.length()];
  }
```

### 比较版本

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

### 获取相同字母

```java
  public static String getCommonLetters(String firstStr, String secondStr) {
    Set<String> commonLetters = new HashSet<>();
    for (Character currentCharacter : firstStr.toCharArray()) {
    if (isCommonLetter(secondStr, currentCharacter)) {
      commonLetters.add(currentCharacter.toString());
     }
    }
    return String.join(" ", commonLetters);
  }

  private static boolean isCommonLetter(String str, Character character) {
    return str.contains(character.toString()) && Character.isLetter(character);
  }
```

### 计算某个字符出现的最大次数

```java
 public static int getMaxCharacterCount(String str, char character) {
   int characterCount = 0;
   int maxCharacterCount = 0;
   for (int i = 0; i < str.length(); i++) {
     if ((str.charAt(i)) == character) {
        characterCount++;
        maxCharacterCount = Math.max(maxCharacterCount, characterCount);
     } else {
        characterCount = 0;
     }
    }
    return maxCharacterCount;
 }
```
### 从字符串中删除重复字符

```java
  public static String removeDuplicateCharacters(String str) {
    char[] charsOfStr = str.toCharArray();
    Set<String> uniqueCharacters = new HashSet<>();
    for (char character : charsOfStr) {
      uniqueCharacters.add(String.valueOf(character));
    }
    return String.join("", uniqueCharacters);
  }
```

## 类

### 获取公开的方法名称列表

```java
  public static List<String> getAllMethods(final Class<?> cls) {
    return Arrays.stream(cls.getDeclaredMethods())
            .map(Method::getName)
            .collect(Collectors.toList());
  }
```

### 获取公开的字段名称列表

```java
  public static List<String> getAllFieldNames(final Class<?> cls) {
    return Arrays.stream(cls.getFields())
            .map(Field::getName)
            .collect(Collectors.toList());
  }
```

### 获取所有的字段名称列表

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

### 无参构造实例化

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


## I/O(输入/输出)

### 按流读取文件

```java
  public static List<String> readFile(String fileName) throws FileNotFoundException {
    try (Stream<String> stream = new BufferedReader(new FileReader(fileName)).lines()) {
      return stream.collect(Collectors.toList());
    }
  }
```

### 输入流到字符串

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


## 线程

### 创建线程数固定的线程池

```java
  public static ExecutorService createFixedThreadPool() {
    return Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
  }
```

## 日期

### 计算no天后的日期
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


### 计算no天后的本地日期
```java
 public static LocalDate addDaysToLocalDate(LocalDate date, long noOfDays){
    return date!=null ? date.plusDays(noOfDays) : null;
 }
```
