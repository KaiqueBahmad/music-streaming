import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { ContentComponent } from './content/content.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HeaderComponent, ContentComponent, FooterComponent],
  template: `
  <app-header></app-header>
  <app-content></app-content>
  <app-footer></app-footer>
  `,
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'front';
}
