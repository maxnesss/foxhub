import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from "./components/login/login.component";
import { MainPageComponent } from "./components/main-page/main-page.component";
import { PeoplePageComponent } from "./components/people-page/people-page.component";
import { ProfilePageComponent } from "./components/profile-page/profile-page.component";
import { RegisterComponent } from "./components/register/register.component";
import { IntroComponent } from "./components/intro/intro.component";
import { PageNotFoundComponent } from "./components/page-not-found/page-not-found.component";
import { UserSettingsPageComponent } from './components/user-settings-page/user-settings-page.component';
import { TermsOfUseComponent } from './components/terms-of-use/terms-of-use.component';
import { ResetPasswordComponent } from './components/reset-password/reset-password.component';
import { ChangePasswordComponent } from "./components/change-password/change-password.component";
import { CartComponent } from "./components/cart/cart.component";
import { CartCheckoutComponent } from "./components/cart-checkout/cart-checkout.component";
import { CreatorsComponent } from "./components/creators/creators.component";
import { PersonalityInfoPageComponent } from "./components/personality-16personalities-page/personality-info-page.component";
import { PersonalityTrueColorComponent } from "./components/personality-true-color-page/personality-true-color.component";
import { AdminBoardComponent } from "./components/admin-board/admin-board.component";
import { SpiritAnimalPageComponent } from './components/spirit-animal-page/spirit-animal-page.component';

const routes: Routes = [
  { path: '', component: PeoplePageComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'main', component: MainPageComponent },
  { path: 'intro', component: IntroComponent },
  { path: 'cart', component: CartComponent },
  { path: 'update-profile', component: UserSettingsPageComponent },
  { path: 'reset-password', component: ResetPasswordComponent },
  { path: 'change-password', component: ChangePasswordComponent },
  { path: 'termsOfUse', component: TermsOfUseComponent },
  { path: 'checkout', component: CartCheckoutComponent },
  { path: 'creators', component: CreatorsComponent },
  { path: '16personalities', component: PersonalityInfoPageComponent },
  { path: 'color-personality-test', component: PersonalityTrueColorComponent },
  { path: 'admin-board', component: AdminBoardComponent },
  { path: 'spirit-animal', component: SpiritAnimalPageComponent },
  { path: ':username', component: ProfilePageComponent },
  { path: '**', pathMatch: 'full', component: PageNotFoundComponent }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {
}
