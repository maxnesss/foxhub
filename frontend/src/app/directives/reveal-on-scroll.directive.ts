import { Directive, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: '[appRevealOnScroll]'
})

export class RevealOnScrollDirective {

  constructor(private elementRef: ElementRef<HTMLElement>) { }

  @HostListener('window:scroll', [])
  onWindowScroll() {
    const element = this.elementRef.nativeElement;
    if (!element.classList.contains('reveal')) {
      if (this.isElementInViewport(element)) {
        element.classList.add('reveal');
      }
    }
  }

  private isElementInViewport(element: HTMLElement): boolean {
    const rect = element.getBoundingClientRect();
    return rect.top >= 0 && rect.bottom <= window.innerHeight;
  }

}
