  # creational-design-patterns

  Creational Patterns

  Yaratımsal desenler, nesnelerin oluşturulma şekliyle ilgilidir. Nesneleri kontrollü bir şekilde oluşturarak karmaşıklıkları ve kararsızlığı azaltır.
  Yaratımsal kalıplar, uygulamanın çalışma süreci içerisinde oluşturulması gereken nesneler ve bu nesnelerin belli yapılar dahilinde oluşturulmasını öngören beş farklı şablondan (desen) oluşur.

  •	Fabrika Metodu (Factory Method)
  •	Soyut Fabrika Metodu (Abstract Factory Pattern)
  •	Tekil Kalıp - Yegane (Singleton Design Pattern)
  •	Yapıcı Kalıp ( Builder Design Pattern)
  •	İlk örnek Kalıp - Örnek ( Prototype Design Pattern)


  Factory Desing Pattern 

  Bir üst sınıfta nesneler oluşturmak için bir arabirim sağlayan, ancak alt sınıfların oluşturulacak nesnelerin türünü değiştirmesine izin veren yaratıcı bir tasarım modelidir.
  Oluşturmak istediğimiz sınıfın kendisinden bir örnek istemek yerine factory method kullanarak tek bir instance üzerinden gerekli nesnelerin üretilmesini sağlamaktır.
  Burada amaç ilişkisel olan birden fazla  nesnenin üretimini  ortak bir arayüz(interface)  aracılığıyla tek bir sınıf üzerinden yapılacak bir talep ile gerçekleştirmek ve nesne üretim anında istemcinin üretilen nesneye olan bağımlılığını sıfıra indirmeye çalışmaktır.

        public interface Shape {
              void draw();
        }

        public class Rectangle implements Shape {

            @Override
            public void draw() {
              System.out.println("Inside Rectangle::draw() method.");
            }
          }


        public class Square implements Shape {

              @Override
              public void draw() {
                  System.out.println("Inside Square::draw() method.");
              }
          }

          public class ShapeFactory {

             //use getShape method to get object of type shape 
              public Shape getShape(String shapeType){
                    if(shapeType == null){
                     return null;
               }		
              if(shapeType.equalsIgnoreCase("CIRCLE")){
               return new Circle();
               } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
                 return new Rectangle();
              } else if(shapeType.equalsIgnoreCase("SQUARE")){
                return new Square();
              }
               return null;
              }
              }

  Singleton Desing Pattern 

  Bir class’tan bir obje yaratılmasını amaçlar. Birden fazla objenin olmaması amacıyla kurulmuştur.
  Singleton deseni, bir sınıfın birden çok nesnesini somutlaştırmasını kısıtlayan bir tasarım desenidir.

  Singleton sınıfının bir uygulaması aşağıdaki özelliklere sahip olmalıdır:
  1.	Yalnızca bir örneği olmalıdır:  Bu, sınıfın bir örneğini sınıf içinden sağlayarak yapılır. Örneği oluşturmak için dış sınıflar veya alt sınıflar engellenmelidir. Bu, yapıcıyı Java'da özel hale getirerek yapılır, böylece hiçbir sınıf yapıcıya erişemez ve dolayısıyla onu somutlaştıramaz.
  2.	Örnek global olarak erişilebilir olmalıdır:  Singleton sınıfının örneği, her sınıfın kullanabilmesi için global olarak erişilebilir olmalıdır. Java'da, örneğin erişim belirtecini herkese açık hale getirerek yapılır.

  Nesneleri new  ile yaratmyoruz. Bunun yerine getInstance metodunu kullanıyoruz. Dosya sistemlerine erişim, loglama, veritabanı bağlantıları gibi yerlerde kullanılır. 

                public class SingletonExample {
                    private static SingletonExample instance;
                    private SingletonExample(){ }
                    private static SingletonExample getInstance(){
                              if(instance == null){
                              instance = new SingletonExample();
                    }
                    return instance;  
                 }

  Builder Desing Pattern

  Aynı yapım sürecinin farklı temsiller oluşturabilmesi için karmaşık bir nesnenin yapımını temsilinden ayırmayı” amaçlar. Adım adım karmaşık bir nesne oluşturmak için kullanılır ve son adım nesneyi döndürür. Bir nesne oluşturma süreci, aynı nesnenin farklı temsillerini oluşturmak için kullanılabilecek şekilde genel olmalıdır.

  •	Çok fazla parametreli bir obje varsa,
  •	Farklı paremetre kombinasyonlarına sahip birden çok constructor varsa ve hangisinin kullanılacağı net değil ise,
  •	Nesnenin oluşturulduktan sonra değiştirilmesini istemiyorsak,
  •	Kodun okunurluğunu artırmak için kullanılır.

  Address address = new Address(“Malatya”,”İstanbul”,”Ankara”,”Elazığ”)   // gibi ne olduğu belli değil ve parametre sayısı çok fazla

  package com.example.creationaldesignpatterns.builder.entity;

            public class User {
              private int tckn;
              private String lastName; 
              private String surName; 
              private String email; 
              private String phone;
              public User() {}
              public User(UserBuilder builder) {
                this.tckn  = builder.tckn;
                this.lastName = builder.lastName;
                this.surName = builder.surName;
                this.phone  = builder.phone;
                this.email  = builder.email;
              }
                public int getTckn() {
                  return tckn;
                }
                public String getLastName() {
                  return lastName;
                }
                public String getSurName() {
                  return surName;
                }
                public String getEmail() {
                  return email;
                }
                public String getPhone() {
                  return phone;
                }

                @Override
                public String toString() {
                  return "User [tckn=" + tckn + ", lastName=" + lastName + ", surName=" + surName + ", email=" + email
                      + ", phone=" + phone + "]";
                }
                public static class UserBuilder {
                  private int tckn;
                  private String lastName;
                  private String surName;
                  private String email;
                  private String phone;
                  public UserBuilder tckn(int tckn) {
                    this.tckn = tckn;
                    return this;
                  }
                  public UserBuilder lastName(String lastName) {
                    this.lastName = lastName;
                    return this;
                  }
                  public UserBuilder surName(String surName) {
                    this.surName = surName;
                    return this;
                  }
                  public UserBuilder email(String email) {
                    this.email = email;
                    return this;
                  }
                  public UserBuilder phone(String phone) {
                    this.phone = phone;
                    return this;
                  }
                  public User build() {
                    return new User(this);
                  }
                }
              }

  Prototype Pattern

  Kodunuzu sınıflarına bağımlı hale getirmeden mevcut nesneleri kopyalamanıza izin veren yaratıcı bir tasarım kalıbıdır. 
  Prototype Pattern kullanılmasının amacı üretilen nesnenin çok kaynak tüketmesi durumunun engellenmesini sağlamaktır.
  
  Yaptığımız projemizde nesnemizi birden fazla oluşturmamız gerektiğinde normalde “new” olarak oluşturmak yerine bir tane oluşturduğumuz nesnemizin klonunu oluşturmamızı sağlayan bir design patterndir.


                    public class Uye implements Cloneable {

                        private List<String> uyeListesi;

                        public Uye() {
                            uyeListesi = new ArrayList<String>();
                        }

                        public Uye(List<String> liste) {
                            this.uyeListesi = liste;
                        }

                        public void uyeEkle() {

                            uyeListesi.add("Burak");
                            uyeListesi.add("Ahmet");
                            uyeListesi.add("Mehmet");
                        }

                        public List<String> getUyeListesi() {
                            return uyeListesi;
                        }

                        @Override
                        public Object clone() throws CloneNotSupportedException {
                            List<String> uyeListesi = new ArrayList<String>();
                            for (String s : this.getUyeListesi()) {
                                uyeListesi.add(s);
                            }
                            return new Uye(uyeListesi);
                         }
                      }







