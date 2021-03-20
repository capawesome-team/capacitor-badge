import { WebPlugin } from '@capacitor/core';

import type {
  BadgePlugin,
  GetBadgeResult,
  SetBadgeOptions,
  PermissionStatus,
} from './definitions';

export class BadgeWeb extends WebPlugin implements BadgePlugin {
  private static STORAGE_KEY = 'capacitor.badge';

  constructor() {
    super();
    this.restore();
  }

  public async checkPermissions(): Promise<PermissionStatus> {
    return { display: 'granted' };
  }

  public async requestPermissions(): Promise<PermissionStatus> {
    return { display: 'granted' };
  }

  public async get(): Promise<GetBadgeResult> {
    const value = localStorage.getItem(BadgeWeb.STORAGE_KEY);
    const count = value ? parseInt(value, 10) : 0;
    return { count };
  }

  public async set(options: SetBadgeOptions): Promise<void> {
    const count = options.count;
    if (count === 0) {
      await navigator.clearAppBadge();
    } else {
      await navigator.setAppBadge(count);
    }
    const value = count.toString();
    localStorage.setItem(BadgeWeb.STORAGE_KEY, value);
  }

  public async clear(): Promise<void> {
    await this.set({ count: 0 });
  }

  private async restore(): Promise<void> {
    const value = localStorage.getItem(BadgeWeb.STORAGE_KEY);
    if (!value) {
      return;
    }
    const count = parseInt(value, 10);
    await navigator.setAppBadge(count);
  }
}

declare global {
  interface Navigator {
    setAppBadge: (count: number) => Promise<void>;
    clearAppBadge: () => Promise<void>;
  }
}
