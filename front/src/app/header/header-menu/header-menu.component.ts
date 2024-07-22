import { Component } from '@angular/core';
import { NgFor } from '@angular/common';
import { DButtonComponent } from '../../components/d-button/d-button.component';

@Component({
  selector: 'app-header-menu',
  standalone: true,
  imports: [DButtonComponent, NgFor],
  template:`
  <div id="header-menu"  *ngFor="let btn of buttons">
    <app-d-button [text]="btn" [redirect]="btn.toLowerCase()" />
  </div>
`,
  styleUrl: './header-menu.component.css'
})
export class HeaderMenuComponent {
  public buttons:string[] = ['Home', 'Search', 'Genres','Playlists']
}
