import { Component } from '@angular/core';
import { HeaderMenuComponent } from './header-menu/header-menu.component';
import { UserInfoComponent } from './user-info/user-info.component';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [HeaderMenuComponent, UserInfoComponent],
  template: `
    <div id="header">
      <h1>Site de Músicas</h1>
      <app-header-menu></app-header-menu>
      <app-user-info></app-user-info>
    </div>
  `,
  styleUrl: './header.component.css'
})
export class HeaderComponent {

}
