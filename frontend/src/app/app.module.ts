import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from "@angular/common/http";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { MainPageComponent } from './components/main-page/main-page.component';
import { ProfilePageComponent } from './components/profile-page/profile-page.component';
import { PeoplePageComponent } from './components/people-page/people-page.component';
import { NgOptimizedImage } from "@angular/common";
import { IntroComponent } from './components/intro/intro.component';
import { httpInterceptorProviders } from "./_helpers/interceptor";
import { PeoplePageCardComponent } from "./components/people-page/people-page-card/people-page-card.component";
import { PeoplePageSearchbarComponent } from "./components/people-page/people-page-searchbar/people-page-searchbar.component";
import { TechnologyComponent } from './components/technology/technology.component';
import { LanguageComponent } from './components/language/language.component';
import { BackToTopBtnComponent } from './components/back-to-top-btn/back-to-top-btn.component';
import { AsideComponent } from './components/aside/aside.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { UserSettingsPageComponent } from './components/user-settings-page/user-settings-page.component';
import { TermsOfUseComponent } from './components/terms-of-use/terms-of-use.component';
import { ResetPasswordComponent } from './components/reset-password/reset-password.component';
import { PostsComponent } from './components/posts-creation-feed/posts.component';
import { PostComponent } from './components/posts-creation-feed/post/post.component';
import { PostFormComponent } from './components/posts-creation-feed/post-form/post-form.component';
import { QRCodeModule } from 'angularx-qrcode';
import { CommonModule } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { LanguageButtonComponent } from './components/language-button/language-button.component';
import { AsideUserCardComponent } from './components/aside/aside-user-card/aside-user-card.component';
import { TechnologyButtonComponent } from './components/technology-button/technology-button.component';
import { AsideSearchBarComponent } from './components/aside/aside-search-bar/aside-search-bar.component';
import { ChangePasswordComponent } from './components/change-password/change-password.component';
import { CartComponent } from './components/cart/cart.component';
import { CardComponent } from './components/cart/card/card.component';
import { CartCheckoutComponent } from './components/cart-checkout/cart-checkout.component';
import { PersonalityComponent } from './components/16personality/personality.component';
import { SwiperArrowComponent } from './components/swiper-arrow/swiper-arrow.component';
import { CreatorsComponent } from './components/creators/creators.component';
import { RevealOnScrollDirective } from './directives/reveal-on-scroll.directive';
import { PersonalityInfoPageComponent } from './components/personality-16personalities-page/personality-info-page.component';
import { RevealWithDelayDirective } from './directives/reveal-with-delay.directive';
import { AdminBoardComponent } from './components/admin-board/admin-board.component';
import { PersonalityTrueColorComponent } from './components/personality-true-color-page/personality-true-color.component';
import { ColorPersonalityComponent } from './components/color-personality/color-personality.component';
import { DonutFillingPageComponent } from './components/donut-filling-page/donut-filling-page.component';
import { SpiritAnimalPageComponent } from './components/spirit-animal-page/spirit-animal-page.component';
import { LocationButtonComponent } from './components/location-button/location-button.component';
import { LocationComponent } from './components/location/location.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    RegisterComponent,
    MainPageComponent,
    ProfilePageComponent,
    PeoplePageComponent,
    IntroComponent,
    PeoplePageCardComponent,
    TechnologyComponent,
    LanguageComponent,
    BackToTopBtnComponent,
    AsideComponent,
    PeoplePageSearchbarComponent,
    PageNotFoundComponent,
    UserSettingsPageComponent,
    TermsOfUseComponent,
    ResetPasswordComponent,
    PostsComponent,
    PostComponent,
    PostFormComponent,
    LanguageButtonComponent,
    AsideUserCardComponent,
    TechnologyButtonComponent,
    AsideSearchBarComponent,
    ChangePasswordComponent,
    CartComponent,
    CardComponent,
    CartCheckoutComponent,
    PersonalityComponent,
    SwiperArrowComponent,
    CreatorsComponent,
    RevealOnScrollDirective,
    PersonalityInfoPageComponent,
    RevealWithDelayDirective,
    AdminBoardComponent,
    PersonalityTrueColorComponent,
    ColorPersonalityComponent,
    DonutFillingPageComponent,
    SpiritAnimalPageComponent,
    LocationButtonComponent,
    LocationComponent,
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    NgOptimizedImage,
    HttpClientModule,
    ReactiveFormsModule,
    QRCodeModule,
    CommonModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot()
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})

export class AppModule {
}
