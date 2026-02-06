package com.example.matulelibrary.shared.card;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aL\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tH\u0007\u001a.\u0010\f\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0003\u001a4\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007\u001a\u0010\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0003H\u0003\u00a8\u0006\u0015"}, d2 = {"Card", "", "nameProduct", "", "money", "", "date", "genre", "visibleClose", "", "visibleCard", "visibleCart", "CardItem", "onClick", "Lkotlin/Function0;", "addedProduct", "CartItem", "quantity", "onPlus", "onMinus", "ProjectItem", "uikitMatule_debug"})
public final class CardKt {
    
    @androidx.compose.runtime.Composable()
    public static final void Card(@org.jetbrains.annotations.NotNull()
    java.lang.String nameProduct, int money, @org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    java.lang.String genre, boolean visibleClose, boolean visibleCard, boolean visibleCart) {
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