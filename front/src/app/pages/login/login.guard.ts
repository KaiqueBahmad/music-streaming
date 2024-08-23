import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { LoginService } from './login.service';

export const loginGuard: CanActivateFn = (route, state) => {
  const router:Router  = inject(Router);
  const loginService:LoginService = inject(LoginService);
  if (!loginService.isLoggedIn()) {
    router.navigate(['/login']);
    return false;
  }
  return true;
};
