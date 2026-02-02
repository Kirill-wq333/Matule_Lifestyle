package com.example.matulelibrary.shared.bottomsheet;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a#\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003\u00a2\u0006\u0002\b\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001aY\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000327\u0010\u0002\u001a3\u0012\u0004\u0012\u00020\f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00010\u0003\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\u000b\u00a2\u0006\u0002\b\u0004\u00a2\u0006\u0002\b\u0010H\u0007\u00a8\u0006\u0011"}, d2 = {"MatuleBottomSheet", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "nameProduct", "", "MatuleModalBottomSheet", "modifier", "Landroidx/compose/ui/Modifier;", "onDismissRequest", "Lkotlin/Function2;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ParameterName;", "name", "hide", "Lkotlin/ExtensionFunctionType;", "uikitMatule_debug"})
public final class MatuleBottomSheetKt {
    
    /**
     * Функция которая отображает данные продукта
     *
     * @param content Функция, которая отображает контент
     * @param nameProduct Текст, который отображает название продукта
     */
    @androidx.compose.runtime.Composable()
    public static final void MatuleBottomSheet(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> content, @org.jetbrains.annotations.NotNull()
    java.lang.String nameProduct) {
    }
    
    /**
     * Функция для отображения модального окна
     *
     * @param modifier Модификатор для настройки внешнего вида и поведения
     * @param onDismissRequest Лямбда-функция, где при нажатии на само "модальное окно" сворачивает его.
     * @param content Функция, которая отображает контент
     */
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void MatuleModalBottomSheet(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismissRequest, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super androidx.compose.foundation.layout.ColumnScope, ? super kotlin.jvm.functions.Function0<kotlin.Unit>, kotlin.Unit> content) {
    }
}