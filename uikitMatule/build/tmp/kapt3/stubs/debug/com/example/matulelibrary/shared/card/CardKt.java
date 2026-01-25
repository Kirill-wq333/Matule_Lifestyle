package com.example.matulelibrary.shared.card;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u0007\u001a.\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0003\u001a4\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0007\u001a\u0010\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0003H\u0003\u00a8\u0006\u0015"}, d2 = {"Card", "", "nameProduct", "", "visibleClose", "", "visibleCard", "visibleCart", "CardItem", "money", "", "genre", "onClick", "Lkotlin/Function0;", "addedProduct", "CartItem", "quantity", "onPlus", "onMinus", "ProjectItem", "date", "uikitMatule_debug"})
public final class CardKt {
    
    @androidx.compose.runtime.Composable()
    public static final void Card(@org.jetbrains.annotations.NotNull()
    java.lang.String nameProduct, boolean visibleClose, boolean visibleCard, boolean visibleCart) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void CardItem(int money, java.lang.String genre, kotlin.jvm.functions.Function0<kotlin.Unit> onClick, boolean addedProduct) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void CartItem(int quantity, int money, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onPlus, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onMinus) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ProjectItem(java.lang.String date) {
    }
}