# Minecraft-Welcomer-Evcil-Hayvan-Plugin

🎮 Minecraft Welcomer & Evcil Hayvan Plugin
Bu proje, Minecraft sunucuları için geliştirilmiş, oyuncu deneyimini zenginleştiren bir Bukkit/Spigot pluginidir.

✨ Özellikler
🎉 Hoş Geldin Sistemi
Özel Başlık Mesajları: Oyuncu girişinde ekran ortasında hoş geldin mesajı

Akıllı Mesaj Sistemi: İlk giriş ve tekrar girişler için farklı mesajlar

Config Yapılandırması: Tüm mesajlar config.yml üzerinden özelleştirilebilir

Renk Kod Desteği: & işaretli renk kodlarıyla kolay kişiselleştirme

🐾 Evcil Hayvan Sistemi
Ücretsiz Evcil Hayvan: Oyunculara bedava köpek veya kedi

Interaktif Menü: Kullanıcı dostu seçim menüsü

Kolay Erişim: Kemiğe sağ tıklayarak menüyü açma

Otomatik Dağıtım: Oyuncu girişinde menü açıcı eşyanın verilmesi

🚀 Kurulum
Release'ten İndir: Releases sayfasından en son .jar dosyasını indirin

Plugins Klasörüne Yerleştir: Dosyayı sunucunuzun plugins/ klasörüne atın

Sunucuyu Yeniden Başlatın: Plugin otomatik olarak yüklenecektir

Config Dosyası: İlk çalıştırmada plugins/Welcomer/config.yml otomatik oluşturulur

⚙️ Yapılandırma
📝 config.yml Örneği
yaml
# Hoş geldin mesajları
first-join-message: "&aHoş geldin &e{player}&a! Sunucumuza ilk kez katılıyorsun!"
welcome-back-message: "&aTekrar hoş geldin &e{player}&a!"
personal-welcome-message: "&6⭐ &eSunucumuza hoş geldin! &aKuralları okumayı unutma :)"
quit-message: "&7[&c-&7] &e{player} &csunucudan ayrıldı!"

# Başlık ayarları
title:
  fadein: 10
  stay: 40
  fadeout: 10
🔧 Özelleştirme Seçenekleri
{player} değişkeni otomatik olarak oyuncu adıyla değiştirilir

Minecraft renk kodları desteklenir (&a, &6, &c vb.)

Başlık süreleri tick cinsinden ayarlanabilir (20 tick = 1 saniye)

🎯 Kullanım
Oyuncular İçin:
Sunucuya Gir: Otomatik olarak hoş geldin mesajı alırsın

Menü Eşyasını Al: Envanterinde kemik şeklinde menü eşyası belirir

Menüyü Aç: Kemik eşyasına sağ tıkla

Evcil Hayvan Seç: Köpek 🐶 veya kedi 🐱 seçeneğine tıkla

Keyfini Çıkar: Evcil hayvanın yanında belirir!

Sunucu Sahipleri İçin:
Config dosyasını düzenleyerek tüm mesajları değiştirebilirsiniz

Plugin restart gerektirmeden config değişikliklerini yükler

🛠️ Geliştirici Bilgileri
📋 Bağımlılıklar
Minecraft Version: 1.13+

Java Version: 8+

Platform: Bukkit/Spigot/Paper

🔨 Derleme
bash
# Projeyi klonla
git clone https://github.com/Yusuf/Welcomer.git

# Gerekli bağımlılıkları yükle
mvn clean install

# Plugin jar dosyasını oluştur
mvn package
🏗️ Kod Yapısı
text
src/
├── main/
│   └── java/
│       └── com/
│           └── Yusuf/
│               └── Welcomer/
│                   └── Main.java
resources/
└── config.yml

🤝 Katkıda Bulunma
Fork oluşturun

Feature branch'i oluşturun (git checkout -b feature/amazing-feature)

Değişikliklerinizi commit edin (git commit -m 'Add amazing feature')

Branch'i push edin (git push origin feature/amazing-feature)

Pull Request oluşturun

📜 Lisans
Bu proje MIT lisansı altında lisanslanmıştır - detaylar için LICENSE dosyasına bakın.

🐛 Hata Bildirimi
Hata bulursanız lütfen Issue sayfasından bildirin.

💡 Öneriler
Yeni özellik önerileriniz için Discussions sayfasını kullanın.

Geliştirici: Yusuf
Destek: GitHub Issues

⭐ Bu projeyi beğendiyseniz yıldız vermeyi unutmayın!

🔄 Güncelleme Geçmişi
v1.0.0
İlk sürüm

Hoş geldin sistemi

Evcil hayvan menüsü

Config yapılandırması

v1.1.0 (Planlanan)
Daha fazla evcil hayvan seçeneği

Evcil hayvan özelleştirme

İstatistik takibi

Multi-dil desteği
