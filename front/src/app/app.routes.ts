import { Routes } from '@angular/router';
import { PlaylistsComponent } from './content/playlists/playlists.component';
import { HomeComponent } from './pages/home/home.component';
import { HeaderComponent } from './header/header.component';

export const routes: Routes = [
    {path:'', redirectTo:'/home', pathMatch:'full'},
    {path:'home', component: HomeComponent},
    {path:'search', component:HeaderComponent}
];
