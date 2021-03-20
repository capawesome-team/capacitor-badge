import { WebPlugin } from '@capacitor/core';

import type {
  BadgePlugin,
  GetBadgeResult,
  SetBadgeOptions,
} from './definitions';

export class BadgeWeb extends WebPlugin implements BadgePlugin {
  private count: number = 0;

  constructor() {
    super();
  }

  public async get(): Promise<GetBadgeResult> {
    return { count: this.count };
  }

  public async set(options: SetBadgeOptions): Promise<void> {
    this.count = options.count;
    await navigator.setAppBadge(options.count);
  }

  public async clear(): Promise<void> {
    this.count = 0;
    await navigator.clearAppBadge();
  }
}

declare global {
  interface Navigator {
    setAppBadge: (count: number) => Promise<void>;
    clearAppBadge: () => Promise<void>;
  }
}
