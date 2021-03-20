import Foundation
import Capacitor

@objc public class Badge: NSObject {
    private let STORAGE_KEY = "capacitor.badge"
    private var defaults: UserDefaults {
        return UserDefaults.standard
    }
    
    override init() {
        super.init()
        restore()
    }
    
    @objc public func get() -> Int {
        return defaults.integer(forKey: STORAGE_KEY)
    }
    
    @objc public func set(count: Int, completion: @escaping () -> Void) {
        DispatchQueue.main.async { [weak self] in
            guard let strongSelf = self else {
                return
            }
            UIApplication.shared.applicationIconBadgeNumber = count
            strongSelf.defaults.set(count, forKey: strongSelf.STORAGE_KEY)
            completion()
        }
    }
    
    @objc public func clear(completion: @escaping () -> Void) {
        set(count: 0, completion: completion)
    }
    
    @objc private func restore() {
        let count = get()
        set(count: count, completion: {})
    }
}
