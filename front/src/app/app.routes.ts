import { Routes } from '@angular/router';
import { PlaylistsComponent } from './content/playlists/playlists.component';
import { HomeComponent } from './pages/home/home.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './pages/login/login.component';
import { loginGuard } from './pages/login/login.guard';

export const routes: Routes = [
    {path:'', redirectTo:'/home', pathMatch:'full'},
    {path:'login', component:LoginComponent},
    {path:'home', component: HomeComponent, canActivate:[loginGuard]},
    {path:'home_', component: HomeComponent},
    {path:'search', component:HeaderComponent}
];
