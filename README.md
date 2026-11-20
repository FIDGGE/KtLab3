# KtLab3 — Лабораторная работа 3. Начало работы с Jetpack Compose

**Цель работы:** ознакомиться с базовыми конструкциями Jetpack Compose: composable-функциями, контейнерами `Column`, `Row`, `Box`, модификаторами, строковыми и графическими ресурсами.

**Автор:** Гончаров Роман, ПИ-251

## Задание

Контрольное задание для самопроверки, четыре приложения по скриншотам из методички:

1. **Compose Article** — баннер, заголовок и два абзаца с выравниванием по ширине, строки в `strings.xml`.
2. **Task Manager** — иконка и два текста по центру экрана. Первый текст жирный, отступ 24dp сверху и 8dp снизу. Второй — 16sp.
3. **Compose Quadrant** — четыре ячейки 2×2 (цвета `0xFFEADDFF`, `0xFFD0BCFF`, `0xFFB69DF8`, `0xFFF6EDFF`), содержимое по центру, отступ 16dp, заголовок жирный с отступом снизу 16dp, текст `Justify`.
4. **My Information** — фото, имя, должность и три строки контактов.

## Реализация

Все задания собраны в одном приложении (`com.example.ktlab3`, Kotlin, Compose, Material 3, minSdk 24). Главный экран — меню из четырёх кнопок. Выбранный экран хранится в `rememberSaveable`, кнопка «Назад» возвращает в меню. Строки вынесены в `res/values/strings.xml`.

| Файл | Назначение |
|---|---|
| `MainActivity.kt` | меню и переключение экранов |
| `ArticleScreen.kt` | задание 1 |
| `TaskManagerScreen.kt` | задание 2 |
| `QuadrantScreen.kt` | задание 3 |
| `InfoScreen.kt` | задание 4 |

Пример: ячейка квадранта (задание 3).

```kotlin
@Composable
private fun QuadrantCell(title: String, body: String, color: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().background(color).padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))
        Text(text = body, textAlign = TextAlign.Justify)
    }
}
```

## Результаты

Сборка: `gradlew.bat assembleDebug` — `BUILD SUCCESSFUL`. Приложение запущено на эмуляторе Medium_Phone_API_37.0.

| Меню | Compose Article |
|---|---|
| ![Меню]<img width="1080" height="2400" alt="01_menu" src="https://github.com/user-attachments/assets/1a719ce2-c31f-4807-8d60-5867af1c2354" />
 | ![Compose Article]<img width="1080" height="2400" alt="02_article" src="https://github.com/user-attachments/assets/8a86c251-79b3-49af-967b-1282308fff60" />
 |

| Task Manager | Compose Quadrant | My Information |
|---|---|---|
| ![Task Manager]<img width="1080" height="2400" alt="03_task_manager" src="https://github.com/user-attachments/assets/cc1064fd-faa5-4212-addd-36a2bbc91c13" />
 | ![Compose Quadrant]<img width="1080" height="2400" alt="04_quadrant" src="https://github.com/user-attachments/assets/27b2cb5e-67f9-474b-8140-dd90cdea99dc" />
 | ![My Information]<img width="1080" height="2400" alt="05_my_information" src="https://github.com/user-attachments/assets/2107fb38-a9a2-434a-bede-d0e02fedf5ae" />
 |

## Вывод

Изучены основы Jetpack Compose: composable-функции, `Column`/`Row`/`Box`, `Arrangement` и `Alignment`, модификаторы `padding`, `weight`, `background`, стилизация текста и работа с ресурсами. Четыре экрана по заданию реализованы и проверены на эмуляторе.
